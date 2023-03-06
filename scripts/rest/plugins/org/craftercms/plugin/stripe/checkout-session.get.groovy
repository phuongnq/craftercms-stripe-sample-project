@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false)
)]

import com.stripe.model.checkout.Session

def sessionId = params.sessionId

if (!sessionId) {
    return [:]
}

return Session.retrieve(sessionId)