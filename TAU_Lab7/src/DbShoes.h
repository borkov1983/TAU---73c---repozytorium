#ifndef DBSHOES_H
#define DBSHOES_H
#include "Shoes.h"
#include "Iterator.h"
#include "DbShoes.h"
#include <string>
#include <list>
using namespace std;

class DbShoes{

    private:
        Iterator iterator;
        list<Shoes> shoesList;

    public:    
        list<Shoes> getAllShoes(){                 
           return shoesList;
        }

        unsigned int getId() {
            return iterator.getId();
        }

        Shoes addShoes(Shoes sh){
            sh.setId(iterator.Increment());           
            shoesList.push_back(sh);
            return sh;
            }

        Shoes findById(unsigned int id){
            list<Shoes>::iterator i = shoesList.begin();
            for(i; i != shoesList.end(); ++i){
                if(i->getId() == id) {
                    return *i;
                }
            }
        throw "Shoe doesn't exist with that ID";
        }

        Shoes remove(unsigned int id){
            Shoes update;
            list<Shoes>::iterator i = shoesList.begin();
            for(i; i != shoesList.end(); ++i){
                if(i->getId() == id){
                    update = *i;
                    shoesList.erase(i);
                    return update;
                }
            }throw "Shoes doesn't exist";

        }  
        int getSizeList(){ 
            return shoesList.size();
        }      

};
#endif