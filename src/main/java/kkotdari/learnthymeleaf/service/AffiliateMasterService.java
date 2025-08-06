package kkotdari.learnthymeleaf.service;

import kkotdari.learnthymeleaf.model.Affiliate;

import java.util.List;

public interface AffiliateMasterService {

    List<Affiliate> getAll();

    Affiliate getDetails(long id);

}
