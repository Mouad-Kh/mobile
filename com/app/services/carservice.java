package com.app.services;


import java.util.ArrayList;
import java.util.List;

import com.app.beans.car;
import com.app.dao.Idao;


    public class carservice implements Idao<car> {

        private List<car> cars;
        private static carservice instance;

        private carservice() {
            this.cars= new ArrayList<>();
        }

        @Override
        public boolean create(car o) {
            return cars.add(o);
        }

        @Override
        public boolean update(car o) {
            return false;
        }

        @Override
        public boolean delete(car o) {
            return cars.remove(o);
        }

        @Override
        public car findById(int id) {
            for(car c : cars){
                if(c.getId() == id)
                    return c;
            }
            return null;
        }

        @Override
        public List<car> findAll() {
            return cars;
        }

        public synchronized static carservice getInstance() {
            if(instance == null)
                instance = new carservice();
            return instance;

        }
    }



