#ifndef ITERATOR_H
#define ITERATOR_H
using namespace std;

class Iterator {

    private: unsigned int i = 0;

    public: Iterator(){}

    public: unsigned int Increment() {
        int previous = i;
        return i++;
    }

        unsigned int getId(){
            return i;
        }
        void setId(unsigned int integer){
            i = integer;
        }

};

#endif