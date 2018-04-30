package com.asadkhan.persistence.auth;

import java.util.HashMap;


public interface AuthenticationService {

    String getUserId();

    String getAgencyId();

    String getAccessToken();

    String getRefreshToken();

    boolean isLoggedIn();

    HashMap<String,String> getAuthMap();

    boolean isProfiled();

    String getReferralCode();

    boolean isPrimaryManager();
}
