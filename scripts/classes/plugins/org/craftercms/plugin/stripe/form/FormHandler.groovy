package plugins.org.craftercms.plugin.stripe.form

interface FormHandler {

    def handle(params, request, siteConfig, siteItemService)

}