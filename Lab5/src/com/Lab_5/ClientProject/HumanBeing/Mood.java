package com.Lab_5.ClientProject.HumanBeing;

import java.io.Serializable;

public enum Mood implements Serializable {
    SADNESS{public String tString(){return "sadness";}},
    APATHY{public String tString(){return "apathy";}},
    FRENZY{public String tString(){return "frenzy";}};

//   public String toString(String mood_name){
//       if(!this.equals(null)){
//           return mood_name;
//       }
//       return null;
//   }

}

