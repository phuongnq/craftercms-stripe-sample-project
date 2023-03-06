/* Fetch prices and update the form */
fetch("/api/plugins/org/craftercms/plugin/stripe/config.json")
  .then(r => r.json())
  .then(({basicPrice, proPrice}) => {
    const basicPriceInput = document.querySelector('#basicPrice');
    basicPriceInput.value = basicPrice;
    const proPriceInput = document.querySelector('#proPrice');
    proPriceInput.value = proPrice;
  })
