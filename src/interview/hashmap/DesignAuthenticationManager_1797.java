package interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager_1797 {


  class AuthenticationManager {

    int timeToLive;

    Map<String, Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {
      this.timeToLive = timeToLive;
      tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
      tokenMap.put(tokenId, currentTime + this.timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
      if (tokenMap.containsKey(tokenId)) {
        if (tokenMap.get(tokenId) <= currentTime) {
          tokenMap.remove(tokenId);
        } else {
          tokenMap.put(tokenId, currentTime + this.timeToLive);
        }
      }
    }

    public int countUnexpiredTokens(int currentTime) {
      tokenMap.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
      return tokenMap.size();
    }
  }

  public static void main(String[] args) {
    DesignAuthenticationManager_1797 design = new DesignAuthenticationManager_1797();
    AuthenticationManager authenticationManager = design.new AuthenticationManager(5);
    authenticationManager
        .renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
    authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
    authenticationManager.countUnexpiredTokens(
        6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
    authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
    authenticationManager.renew("aaa",
        8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
    authenticationManager.renew("bbb",
        10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
    authenticationManager.countUnexpiredTokens(
        15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.

  }
}
