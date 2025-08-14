package kkotdari.learnthymeleaf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kkotdari.learnthymeleaf.model.Menu;
import kkotdari.learnthymeleaf.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final  String menus = "[{\"parentId\": \"\",\"order\": 1,\"id\": \"affiliates\",\"name\": \"제휴사\",\"path\": \"\",\"subs\": [{\"parentId\": \"affiliates\",\"order\": 1,\"id\": \"affiliates/masters\",\"name\": \"제휴사 마스터\",\"path\": \"affiliates/masters\",\"subs\": []},{\"parentId\": \"affiliates\",\"order\": 2,\"id\": \"affiliates/rewards\",\"name\": \"리워드 관리\",\"path\": \"affiliates/rewards\",\"subs\": []},{\"parentId\": \"affiliates\",\"order\": 3,\"id\": \"affiliates/reconciliations\",\"name\": \"대사 관리\",\"path\": \"affiliates/reconciliations\",\"subs\": []},{\"parentId\": \"affiliates\",\"order\": 4,\"id\": \"affiliates/settlements\",\"name\": \"정산 관리\",\"path\": \"affiliates/settlements\",\"subs\": []}]}]";

    @Override
    public List<Menu> getMenus() {
        try {
            return objectMapper.readValue(menus, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
