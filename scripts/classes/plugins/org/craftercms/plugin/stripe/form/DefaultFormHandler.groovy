package plugins.org.craftercms.plugin.stripe.form

@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false)
])

import com.stripe.Stripe
import com.stripe.model.Event
import com.stripe.exception.*
import com.stripe.net.Webhook
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams

import groovy.util.logging.Slf4j

@Slf4j
class DefaultFormHandler implements FormHandler {
    def handle(params, request, response, siteConfig, siteItemService) {
        Stripe.apiKey = siteConfig.getString('stripe.secretKey')
        Stripe.setAppInfo(
            'craftercms-plugin-stripe',
            '1.0.0',
            'https://github.com/phuongnq/craftercms-plugin-stripe'
        )

        SessionCreateParams sessionParams = new SessionCreateParams.Builder()
            .setSuccessUrl('/plugins/org/craftercms/plugin/stripe/success.ftl?session_id={CHECKOUT_SESSION_ID}')
            .setCancelUrl('/plugins/org/craftercms/plugin/stripe/canceled.ftl')
            .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
            .addLineItem(new SessionCreateParams.LineItem.Builder()
                .setQuantity(1L)
                .setPrice(params.priceId)
                .build()
            )
            .build()
        try {
            Session session = Session.create(sessionParams)
            response.redirect(session.getUrl(), 303)
            return ''
        } catch(Exception e) {
            Map<String, Object> messageData = new HashMap<>()
            messageData.put('message', e.getMessage())
            Map<String, Object> responseData = new HashMap<>()
            responseData.put('error', messageData)
            response.setStatus(400)
            return responseData
        }
    }
}