def result = [:]

result.publishableKey = siteConfig.getString('stripe.publishableKey')
result.basicPrice = siteConfig.getString('basicPrice')
result.proPrice = siteConfig.getString('proPrice')

return result
