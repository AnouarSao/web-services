/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/**
 *
 * @author Anouar-Sao
 */
public class Plat {

    private ArrayList<Menu> menus = new ArrayList<>();
    private long index = 0;

    public ArrayList<Menu> getAllMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        menu.setId(index);
        index++;
        menus.add(menu);
    }

    public Optional<Menu> findMenuById(Long id) {
        Optional<Menu> o = Optional.empty();

        for (Menu m : menus) {
            if (m.getId().equals(id)) {
                o = Optional.of(m);
                break;
            }
        }
        return o;
    }

//    public void deleteMenu(long id) {
//        Iterator<Menu> it = menus.iterator();
//        while (it.hasNext()) {
//            Menu m = it.next();
//            if (m.getId().equals(id)) {
//                menus.remove(m);
//                break;
//            }
//        }
//    }
    
    public void deleteMenu(Menu menu) {
        Iterator<Menu> it = menus.iterator();
        while (it.hasNext()) {
            Menu m = it.next();
            if (m.getId().equals(menu.getId())) {
                menus.remove(m);
                break;
            }
        }
    }

    public void updateMenu(Menu menu) {
        Iterator<Menu> it = menus.iterator();
        while (it.hasNext()) {
            Menu m = it.next();
            if (m.getId().equals(menu.getId())) {
                menus.remove(m);
                menus.add(menu);
                break;
            }
        }
    }
}
