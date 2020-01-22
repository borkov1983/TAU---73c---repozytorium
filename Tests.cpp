#define CATCH_CONFIG_MAIN
#include "lib/catch.hpp"
#include "src/Iterator.h"
#include "src/Shoes.h"
#include "src/DbShoes.h"


///Get All Shoes/////
TEST_CASE("Tests for getAllShoes") {

    SECTION("Check method GetAllShoes is implemented"){
        DbShoes dataBase =  DbShoes();
        REQUIRE_NOTHROW(dataBase.getAllShoes());
    }

    SECTION("Is returns empty database "){
        DbShoes dataBase = DbShoes();
        list<Shoes> allShoes = dataBase.getAllShoes();
        REQUIRE (allShoes.size()==0);
        }

    SECTION("getSizeList method works and return number of shoes.") {
        DbShoes dataBase = DbShoes();
        Shoes sh1(40,"Nike","brown");
        Shoes sh2(43,"Puma","white");
        dataBase.addShoes(sh1);
        dataBase.addShoes(sh2);
        REQUIRE( dataBase.getAllShoes().size() == dataBase.getSizeList() );
        REQUIRE( dataBase.getSizeList() == 2 );
    }
  
}

///Add Shoes/////
TEST_CASE("Tests for add shoes") {

    SECTION("The database object can be created", "[DataBase][constructors]") {
    REQUIRE_NOTHROW([]() { DbShoes db; });
  }

    SECTION("Does method works"){
        DbShoes dataBase = DbShoes();
        REQUIRE_NOTHROW(dataBase.addShoes(Shoes (40,"Nike","brown")));
    }

    SECTION("Object is added to database"){
        DbShoes dataBase =  DbShoes();
        Shoes newShoes = Shoes(40,"Nike","brown");
        REQUIRE_NOTHROW( dataBase.addShoes(newShoes) );
        REQUIRE_FALSE(dataBase.getSizeList() == 0);
        REQUIRE(dataBase.getSizeList() == 1); 
    }
}

///Find Shoe by Id/////
TEST_CASE("Tests for get shoes by id") {

    SECTION ("method findById should throws failure") {
        DbShoes dataBase =  DbShoes();
        REQUIRE_THROWS(dataBase.findById(0));}

    SECTION("Check does method works"){
        DbShoes dataBase =  DbShoes();
        dataBase.addShoes(Shoes (40,"Nike","brown"));
        REQUIRE_NOTHROW( dataBase.findById(0).getId() == 0 );
        REQUIRE_THROWS( dataBase.findById(1) );
    }

    SECTION("When shoe (id) doesn't exist, findById method throw: 'Shoe doesn't exist with that ID'") {
        DbShoes dataBase =  DbShoes();
        dataBase.addShoes(Shoes (41,"Adidas","brown"));
        CHECK_THROWS( dataBase.findById(999) );
        CHECK_THROWS_WITH(dataBase.findById(999), "Shoe doesn't exist with that ID");
     }
    
}

///Delete Shoe from Database/////
TEST_CASE("Tests for delete shoes") {
    SECTION("method remove should throws failure"){
        DbShoes dataBase =  DbShoes();
        REQUIRE_THROWS(dataBase.remove(1));
        
    }

    SECTION("Delete shoes with id which not exists"){
        DbShoes dataBase =  DbShoes();
        dataBase.addShoes(Shoes (45,"Kalosze","grey"));
        CHECK_THROWS_WITH(dataBase.remove(2), "Shoes doesn't exist");
        REQUIRE(dataBase.remove(0).getId() == 0);
        CHECK_THROWS(dataBase.remove(1).getId() == 1);
    }

    SECTION("Check Database when shoes is removed"){
        DbShoes dataBase =  DbShoes();
        dataBase.addShoes(Shoes (40,"Puma","grey"));
        dataBase.addShoes(Shoes (41,"Nike","pink"));
        dataBase.addShoes(Shoes (45,"Adidas","orange"));
        REQUIRE(dataBase.getSizeList() == 3);
        dataBase.remove(1);
        REQUIRE(dataBase.getSizeList() == 2);
        REQUIRE_NOTHROW( dataBase.findById(0).getId() == 0 );
        CHECK_THROWS( dataBase.findById(1).getId() == 1 );
        REQUIRE_NOTHROW( dataBase.findById(2).getId() == 2 );
    }
}

///Iterator/////
TEST_CASE("Tests for iterator") {

    SECTION("Check iterator works property"){
        Iterator iterator = Iterator();
        REQUIRE( iterator.Increment() == 0 );
        REQUIRE( iterator.Increment() == 1 ); 
        REQUIRE_FALSE( iterator.Increment() == 3 );
        REQUIRE( iterator.Increment() == 3 );
    }

    SECTION("Check iterator adds id to object"){
        DbShoes dataBase =  DbShoes();
        dataBase.addShoes(Shoes (40,"Puma","grey"));
        REQUIRE(dataBase.getId() == 1);    
    }
}

///Database/////
TEST_CASE("Tests for Database") {

  SECTION("Object can be created", "[Shoes][constructors]") {
    REQUIRE_NOTHROW([]() { Shoes sh; });
  }

  SECTION("Constructor with 4 elements") {
    REQUIRE_NOTHROW([]() { Shoes sh(1, 39, "Reabok", "black"); });
  }

  SECTION("Constructor with 3 elements") {
    REQUIRE_NOTHROW([]() { Shoes sh(39, "Reabok", "black"); });
  }
}

