def result = [:]

result.publishableKey = siteConfig.getString('stripe.publishableKey')
result.basicPrice = siteConfig.getString('stripe.basicPrice')
result.proPrice = siteConfig.getString('stripe.proPrice')

return result
