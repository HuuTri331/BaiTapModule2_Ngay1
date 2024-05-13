package model;

import java.time.LocalDateTime;
import java.util.List;

    public class Bill {
        private int id;
        private String nameStaff;
        private LocalDateTime dateTime;
        private List<Cart> bill;

        public Bill(int id, String nameStaff, LocalDateTime dateTime, List<Cart> bill) {
            this.id = id;
            this.nameStaff = nameStaff;
            this.dateTime = dateTime;
            this.bill = bill;
        }

        public Bill() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNameStaff() {
            return nameStaff;
        }

        public void setNameStaff(String nameStaff) {
            this.nameStaff = nameStaff;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }

        public List<Cart> getBill() {
            return bill;
        }

        public void setBill(List<Cart> bill) {
            this.bill = bill;
        }


    }
