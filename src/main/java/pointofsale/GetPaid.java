package pointofsale;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

class ModemDidNotConnectException extends Exception {
}

class ModemLibrary {
  public static void dialModem(int number) throws ModemDidNotConnectException {
    if (Math.random() > 0.5) throw new ModemDidNotConnectException();
  }
}

class RetryCCLaterException extends Exception {
  public RetryCCLaterException(Throwable cause) {
    super(cause);
  }
  // Should have full suite of constructors!!! Omitted for example brevity
}
public class GetPaid {
  private static boolean USING_NETWORK = true;

  public static void authorizePayment(int cc, int amount)
//      throws ModemDidNotConnectException, IOException { // IMPLEMENTATION DETAIL
      throws RetryCCLaterException /*, NoMoney, Thief */ { // NOT IMPLEMENTATION DETAIL :)
    int retries = 3;
    boolean success = false;
    while (!success) {
      try {
        if (USING_NETWORK) {
          // use network
          Socket s = new Socket("127.0.0.1", 8080);
        } else {
          ModemLibrary.dialModem(1234561234); // implementation detail
        }
        // connect, security, make payment request.
      } catch (IOException | ModemDidNotConnectException mdnce) {
        retries--;
        if (retries == 0) throw new RetryCCLaterException(mdnce);
      }
    }
  }

  public static void sellStuff() {
    // get price
    // get payment method
    try {
      authorizePayment(123, 123);
    } catch (RetryCCLaterException m) { // Makes sense to me !
//    } catch (ModemDidNotConnectException | IOException m) { // What is this??

    }
  }
}
