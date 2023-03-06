@Grapes([
    @Grab(group='com.stripe', module='stripe-java', version='22.10.0', initClass=false),
    @Grab(group='com.google.code.gson', module='gson', version='2.10', initClass=false)
])

import com.stripe.model.checkout.Session
import com.google.gson.Gson

def sessionId = params.sessionId

if (!sessionId) {
    return [:]
}

Session session = Session.retrieve(sessionId)
Gson gson = new Gson()

return gson.toJson(session)