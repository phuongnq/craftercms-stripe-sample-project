def result = [:]

result.publishableKey = siteConfig.get('stripe.publishableKey')
result.basicPrice = siteConfig.get('basicPrice')
result.proPrice = siteConfig.get('proPrice')

return result
