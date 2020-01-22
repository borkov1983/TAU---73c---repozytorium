#define CATCH_CONFIG_MAIN
#include "lib/catch.hpp"
#include "src/Iterator.h"
#include "src/Shoes.h"
#include "src/DbShoes.h"

SCENARIO( "Tests for delete shoe" ) {
    GIVEN("Database works property"){
        DbShoes dataBase =  DbShoes();
        REQUIRE_NOTHROW(dataBase.addShoes(Shoes (44,"Puma", "black")));
        REQUIRE_NOTHROW(dataBase.getAllShoes());
        REQUIRE_NOTHROW(dataBase.getId());
        REQUIRE_NOTHROW(dataBase.findById(0));
        REQUIRE_NOTHROW(dataBase.getSizeList());
        REQUIRE_NOTHROW(dataBase.remove(0));

        WHEN("I try check size my database"){
            THEN("Database should be empty"){
                REQUIRE(dataBase.getSizeList()==0);           
            }

        }
        WHEN("I add 3 objects"){
            dataBase.addShoes(Shoes (41,"Puma", "blue"));
            dataBase.addShoes(Shoes (43,"Adidas", "red"));
            dataBase.addShoes(Shoes (45,"Reabok", "green"));

            THEN("Size of Database should be 3"){
                CHECK(dataBase.getSizeList()==3);
            }
            AND_WHEN("I remove one of them"){
                dataBase.remove(2);

                THEN("Size of Database should be 2"){
                    CHECK(dataBase.getSizeList()==2);
                }

                AND_THEN("In database is only shoes with id=1 and id=3"){
                    CHECK(dataBase.findById(1).getId()==1);
                    CHECK(dataBase.findById(3).getId()==3);
                    CHECK_THROWS_WITH(dataBase.findById(2).getId()==2, "Shoe doesn't exist with that ID");
                }
            }
        }
        WHEN("I try remove an object that does not exist"){

            THEN("message appears"){
                CHECK_THROWS_WITH(dataBase.remove(99),"Shoes doesn't exist" );
            }
        }
    }
}