package pointofsale;

class ModemDidNotConnectException extends Exception {
}

class ModemLibrary {
  public static void dialModem(int number) throws ModemDidNotConnectException {
    if (Math.random() > 0.5) throw new ModemDidNotConnectException();
  }
}

public class GetPaid {

  public static void authorizePayment(int cc, int amount)
      throws ModemDidNotConnectException {
    int retries = 3;
    boolean success = false;
    while (!success) {
      try {
        // dial modem
        ModemLibrary.dialModem(1234561234);
        // connect
        // security
        // make payment request.
      } catch (ModemDidNotConnectException mdnce) {
        retries--;
        if (retries == 0) throw mdnce;
      }
    }
  }

  public static void sellStuff() {
    // get price
    // get payment method
    try {
      authorizePayment(123, 123);
    } catch (ModemDidNotConnectException m) {
      
    }
  }
}
