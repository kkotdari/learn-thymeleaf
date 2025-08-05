package kkotdari.thymeleaf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kkotdari.thymeleaf.model.Menu;
import kkotdari.thymeleaf.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMenuService implements MenuService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<Menu> getMenus() {
        final String menus = "[{\"parentId\": \"\",\"order\": 1,\"id\": \"affiliate\",\"name\": \"제휴사\",\"path\": \"\",\"subs\": [{\"parentId\": \"affiliate\",\"order\": 1,\"id\": \"affiliate/master\",\"name\": \"제휴사 마스터\",\"path\": \"affiliate/master\",\"subs\": []},{\"parentId\": \"affiliate\",\"order\": 2,\"id\": \"affiliate/reward\",\"name\": \"리워드 관리\",\"path\": \"affiliate/reward\",\"subs\": []},{\"parentId\": \"affiliate\",\"order\": 3,\"id\": \"affiliate/reconciliation\",\"name\": \"대사 관리\",\"path\": \"affiliate/reconciliation\",\"subs\": []},{\"parentId\": \"affiliate\",\"order\": 4,\"id\": \"affiliate/settlement\",\"name\": \"정산 관리\",\"path\": \"affiliate/settlement\",\"subs\": []}]}]";
        try {
            @SuppressWarnings("unchecked")
            List<Menu> list = objectMapper.readValue(menus, List.class);
            return list;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
