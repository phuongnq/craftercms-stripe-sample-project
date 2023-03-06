<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Stripe Checkout Sample</title>
    <meta name="description" content="A demo of Stripe Payment Intents" />

    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/normalize.css" />
    <link rel="stylesheet" href="/static-assets/plugins/org/craftercms/plugin/stripe/css/global.css" />
    <!-- Load Stripe.js on your website. -->
    <script src="https://js.stripe.com/v3/"></script>
    <script src="/static-assets/plugins/org/craftercms/plugin/stripe/js/script.js" defer></script>
  </head>

  <body>
    <div class="togethere-background"></div>
    <div class="sr-root">
      <div class="sr-main">
        <header class="sr-header">
          <div class="sr-header__logo"></div>
        </header>
        <h1>Choose a collaboration plan</h1>

        <div class="price-table-container">
          <section>
            <form action="/plugins/org/craftercms/plugin/stripe/create-checkout-session" method="post">
              <input type="hidden" id="basicPrice" name="priceId">
              <img
                src="/static-assets/plugins/org/craftercms/plugin/stripe/img/starter.png"
                width="120"
                height="120"
                />
              <div class="name">Starter</div>
              <div class="price">$12</div>
              <div class="duration">per month</div>
              <button id="basic-plan-btn">Select</button>
            </form>
          </section>
          <section>
            <form action="/plugins/org/craftercms/plugin/stripe/create-checkout-session" method="post">
              <input type="hidden" id="proPrice" name="priceId">
              <img
                src="/static-assets/plugins/org/craftercms/plugin/stripe/img/professional.png"
                width="120"
                height="120"
                />
              <div class="name">Professional</div>
              <div class="price">$18</div>
              <div class="duration">per month</div>
              <button id="pro-plan-btn">Select</button>
            </form>
          </section>
        </div>
      </div>
    </div>
    <div id="error-message" class="error-message"></div>
  </body>
</html>
