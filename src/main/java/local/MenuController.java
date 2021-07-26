package local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @PostMapping("/menus")
    void menuInsert(@RequestBody Menu data) {
        menuRepository.save(data);
    }

    @PutMapping("/menus/{menuId}")
    void decreasePcnt(@PathVariable(value = "menuId") Long menuId) {

        Optional<Menu> a = menuRepository.findById(menuId);
        if (a.isPresent()) {
            Menu b = a.get();
            b.setPCnt(b.getPCnt() - 1);
            menuRepository.save(b);
        }
    }

    @GetMapping("/menus")
    Iterable<Menu> getMenuList() {
        Iterable<Menu> result = menuRepository.findAll();
        return result;
    }

    @GetMapping("/menus/{menuId}")
    Menu getMenuById(@PathVariable(value = "menuId") Long menuId) {
        System.out.println("productStockCheck call");
        Optional<Menu> a = menuRepository.findById(menuId);
        return a.get();
    }

    @DeleteMapping("/menus/{menuId}")
    void menuDelete(@PathVariable(value = "menuId") Long menuId) {
        menuRepository.deleteById(menuId);

    }

}
