/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

enum ClientType {
    ADULTMALE{
        public String asString(){
            return "Adult Male";
        }
    },
    ADULTFEMALE{
        public String asString(){
            return "Adult Female";
        }

    },
    CHILDOVER8{
        public String asString(){
            return "Child Over 8";
        }

    },
    CHILDUNDER8{
        public String asString(){
            return "Child Under 8";
        }
    };
    public abstract String asString();
}
