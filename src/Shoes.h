#ifndef SHOES_H
#define SHOES_H
#include <string>
#include <iostream>
using namespace std;

class Shoes{
    private:
    unsigned int id;
    int size;
    string brand;
    string color;

public: Shoes() {
    }

    public: 
        Shoes(unsigned int ID, int SIZE, string BRAND, string COLOR) {
            setId(ID);
            setSize(SIZE);
            setBrand(BRAND);
            setColor(COLOR);
        }

        Shoes(int SIZE, string BRAND, string COLOR) {
            setSize(SIZE);
            setBrand(BRAND);
            setColor(COLOR);
        }

    public:
        int getId() {
            return id;
        }
    
        void setId(unsigned int ID) {
            id = ID;
        }

        int getSize() {
            return size;
        }

        void setSize(unsigned int SIZE) {
            size = SIZE;
        }

        string getBrand() {
            return brand;
        }

        void setBrand(string BRAND) {
            brand = BRAND;
        }

        string getColor() {
            return color;
        }

        void setColor(string COLOR) {
            color = COLOR;
    }

};
#endif