@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false)
)]

import com.stripe.Stripe
import com.stripe.model.Event
import com.stripe.exception.*
import com.stripe.net.Webhook
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams

SessionCreateParams params = new SessionCreateParams.Builder()
    .setSuccessUrl("/plugins/org/craftercms/plugin/stripe/success.ftl?session_id={CHECKOUT_SESSION_ID}")
    .setCancelUrl("/plugins/org/craftercms/plugin/stripe/canceled.ftl")
    .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
    .addLineItem(new SessionCreateParams.LineItem.Builder()
        .setQuantity(1L)
        .setPrice(request.queryParams("priceId"))
        .build()
    )
    .build()
try {
    Session session = Session.create(params)
    response.redirect(session.getUrl(), 303)
    return ""
} catch(Exception e) {
    Map<String, Object> messageData = new HashMap<>()
    messageData.put("message", e.getMessage())
    Map<String, Object> responseData = new HashMap<>()
    responseData.put("error", messageData)
    response.status(400)
    return responseData
}