package com.asadkhan.persistence.auth;


import com.asadkhan.persistence.sharedPreferences.PreferenceService;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.asadkhan.persistence.SharedPrefConstants.ACCESS_TOKEN;
import static com.asadkhan.persistence.SharedPrefConstants.AGENCY_ID;
import static com.asadkhan.persistence.SharedPrefConstants.IS_PROFILED;
import static com.asadkhan.persistence.SharedPrefConstants.MANAGER_TYPE;
import static com.asadkhan.persistence.SharedPrefConstants.REFERRAL_CODE;
import static com.asadkhan.persistence.SharedPrefConstants.REFRESH_TOKEN;
import static com.asadkhan.persistence.SharedPrefConstants.USER_ID;

@Singleton
public class AuthenticationManager implements AuthenticationService {

    private static final String AUTHORIZATION = "Authorization";

    private final PreferenceService service;

    @Inject
    public AuthenticationManager(PreferenceService service) {
        this.service = service;
    }

    @Override
    public String getUserId() {
        return this.service.get(USER_ID, "");
    }

    @Override
    public String getAgencyId() {
        return this.service.get(AGENCY_ID, "");
    }

    @Override
    public String getAccessToken() {
        return this.service.get(ACCESS_TOKEN, "");
    }

    @Override
    public String getRefreshToken() {
        return this.service.get(REFRESH_TOKEN, "");
    }

    @Override
    public boolean isLoggedIn() {
        return !getAccessToken().isEmpty();
    }

    @Override
    public HashMap<String, String> getAuthMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(AUTHORIZATION, String.format("Bearer %s", getAccessToken()));
        return hashMap;
    }

    @Override
    public boolean isProfiled() {
        return this.service.get(IS_PROFILED, false);
    }

    @Override
    public String getReferralCode() {
        return this.service.get(REFERRAL_CODE, "");
    }

    @Override
    public boolean isPrimaryManager() {
        String type = service.get(MANAGER_TYPE, "");
        return !(type == null || type.isEmpty() || type.equalsIgnoreCase("S"));
    }
}
