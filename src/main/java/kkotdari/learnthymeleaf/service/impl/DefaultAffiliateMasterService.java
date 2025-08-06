package kkotdari.learnthymeleaf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kkotdari.learnthymeleaf.model.Affiliate;
import kkotdari.learnthymeleaf.service.AffiliateMasterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAffiliateMasterService implements AffiliateMasterService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String affiliatesJson = "[{\"id\":1,\"name\":\"이니스프리\",\"ticker\":\"INFR\",\"startDate\":\"2025-06-23\",\"endDate\":\"2025-11-01\",\"totalConvertedPoints\":24803},{\"id\":2,\"name\":\"예스24\",\"ticker\":\"YES24\",\"startDate\":\"2025-07-25\",\"endDate\":\"2025-12-25\",\"totalConvertedPoints\":47551},{\"id\":3,\"name\":\"롯데리아\",\"ticker\":\"LOTR\",\"startDate\":\"2025-09-16\",\"endDate\":\"2025-10-23\",\"totalConvertedPoints\":98200},{\"id\":4,\"name\":\"11번가\",\"ticker\":\"ELEVEN\",\"startDate\":\"2025-05-02\",\"endDate\":\"2025-07-17\",\"totalConvertedPoints\":18420},{\"id\":5,\"name\":\"뚜레쥬르\",\"ticker\":\"TOUS\",\"startDate\":\"2025-06-11\",\"endDate\":\"2025-10-21\",\"totalConvertedPoints\":62417},{\"id\":6,\"name\":\"쿠팡\",\"ticker\":\"CPNG\",\"startDate\":\"2025-05-14\",\"endDate\":\"2025-10-07\",\"totalConvertedPoints\":84609},{\"id\":7,\"name\":\"전자랜드\",\"ticker\":\"ELAND\",\"startDate\":\"2025-11-11\",\"endDate\":\"2026-03-03\",\"totalConvertedPoints\":17344},{\"id\":8,\"name\":\"티몬\",\"ticker\":\"TMON\",\"startDate\":\"2025-10-18\",\"endDate\":\"2025-12-28\",\"totalConvertedPoints\":30397},{\"id\":9,\"name\":\"아리따움\",\"ticker\":\"ARIT\",\"startDate\":\"2025-07-23\",\"endDate\":\"2026-01-09\",\"totalConvertedPoints\":70982},{\"id\":10,\"name\":\"파리바게뜨\",\"ticker\":\"PBAG\",\"startDate\":\"2025-09-28\",\"endDate\":\"2026-03-23\",\"totalConvertedPoints\":15298},{\"id\":11,\"name\":\"던킨도너츠\",\"ticker\":\"DNKN\",\"startDate\":\"2025-09-07\",\"endDate\":\"2025-11-26\",\"totalConvertedPoints\":53826},{\"id\":12,\"name\":\"ABC마트\",\"ticker\":\"ABCM\",\"startDate\":\"2025-10-10\",\"endDate\":\"2026-02-03\",\"totalConvertedPoints\":31770},{\"id\":13,\"name\":\"SSG.COM\",\"ticker\":\"SSGC\",\"startDate\":\"2025-06-24\",\"endDate\":\"2025-09-16\",\"totalConvertedPoints\":60320},{\"id\":14,\"name\":\"올리브영\",\"ticker\":\"OLY\",\"startDate\":\"2025-10-13\",\"endDate\":\"2026-02-22\",\"totalConvertedPoints\":78944},{\"id\":15,\"name\":\"위메프\",\"ticker\":\"WMF\",\"startDate\":\"2025-11-07\",\"endDate\":\"2026-04-28\",\"totalConvertedPoints\":42130},{\"id\":16,\"name\":\"이마트24\",\"ticker\":\"EMT24\",\"startDate\":\"2025-10-06\",\"endDate\":\"2026-03-10\",\"totalConvertedPoints\":92177},{\"id\":17,\"name\":\"미니스톱\",\"ticker\":\"MSTOP\",\"startDate\":\"2025-07-12\",\"endDate\":\"2025-11-27\",\"totalConvertedPoints\":11963},{\"id\":18,\"name\":\"G마켓\",\"ticker\":\"GMKT\",\"startDate\":\"2025-10-28\",\"endDate\":\"2026-03-14\",\"totalConvertedPoints\":77714},{\"id\":19,\"name\":\"정관장\",\"ticker\":\"JKS\",\"startDate\":\"2025-05-05\",\"endDate\":\"2025-07-17\",\"totalConvertedPoints\":36751},{\"id\":20,\"name\":\"CJ더마켓\",\"ticker\":\"CJMK\",\"startDate\":\"2025-10-21\",\"endDate\":\"2025-12-31\",\"totalConvertedPoints\":68312}]";

    @Override
    public List<Affiliate> getAll() {
        try {
            return objectMapper.readValue(affiliatesJson, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Affiliate getDetails(long id) {
        try {
            List<Affiliate> list = objectMapper.readValue(affiliatesJson, new TypeReference<>() {});

        return list.stream()
                    .filter(a -> a.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
