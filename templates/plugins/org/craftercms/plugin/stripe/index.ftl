<#import "/templates/system/common/crafter.ftl" as crafter />
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
    <@crafter.head/>
  </head>

  <body>
    <@crafter.body_top/>
    <div class="togethere-background"></div>
    <div class="sr-root">
      <div class="sr-main">
        <header class="sr-header">
          <div class="sr-header__logo"></div>
        </header>
        <@crafter.h1 $field="heading_t">${contentModel.heading_t}</@crafter.h1>

        <div class="price-table-container">
          <@crafter.renderRepeatGroup
            $field="plans_o";
            item, index
          >
            <@crafter.section
              $field="plans_o"
              $index="${index}"
            >
              <form action="/plugins/org/craftercms/plugin/stripe/create-checkout-session" method="POST">
                <input type="hidden" id="${item.priceName_s}" name="priceId">
                <@crafter.img
                  $field="plans_o.thumbnail_s"
                  $index="${index}"
                  src="${item.thumbnail_s}"
                  alt="item.title_s"
                  width="120"
                  height="120"
                />
                <@crafter.div
                  $field="plans_o.title_s"
                  $index="${index}"
                  class="name"
                >
                  ${item.title_s}
                </div>
                <@crafter.div
                  $field="plans_o.price_s"
                  $index="${index}"
                  class="name"
                >
                  ${item.price_s}
                </div>
                <div class="duration">per month</div>
                <button id="basic-plan-btn">Select</button>
              </form>
            </@craftercms.section>
          </@crafter.renderRepeatGroup>
        </div>
      </div>
    </div>
    <div id="error-message" class="error-message"></div>
    <@crafter.body_bottom/>
  </body>
</html>
