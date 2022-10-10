package com.Lab_5.Storage;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.HumanBeing.Mood;
import com.Lab_5.Support.*;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Data {

     private String filename_from;
     private LinkedList<HumanBeing> dataSet;
     private long id = 0;
     private ZonedDateTime time = ZonedDateTime.now();

     public Data(){}

     public Data(String fileName, Parser parser, ReadFromFile reader) throws IOException {
          filename_from = fileName;
          initFromFiledataSet(fileName, parser, reader);
     }

     private void initFromFiledataSet(String fileName, Parser<LinkedList<HumanBeing>> parser, ReadFromFile reader) throws IOException {

          System.out.println("Data loading...");
          dataSet = parser.parsing(reader.readFromFile(fileName));
          dataSet.sort(new Comparator<HumanBeing>() {
               @Override
               public int compare(HumanBeing o1, HumanBeing o2) {
                    return o1.compareTo(o2);
               }
          });
          if(dataSet.size()!=0) {
               id = dataSet.getLast().getId();
               System.out.println("Data was loaded successfully.");
          }
          else{
               System.out.println("Data is empty  but you can add HumanBeings and save it.");
          }
          //надо бы проверить на одинаковые id и выкинуть если что exception
     }

     public void setId(){
          if(dataSet.size() == 0)
               id = 0;
          else
               id = dataSet.getLast().getId();
     }

     public void add(String name, Coordinates coordinates, boolean realHero,
                     Boolean hasToothpick, double impactSpeed, String soundtrackName, double minutesOfWaiting, Mood mood,
                     Car car){
          dataSet.add(new HumanBeing(id+1, name, coordinates, ZonedDateTime.now(), realHero, hasToothpick, impactSpeed, soundtrackName,
                  minutesOfWaiting, mood, car));
          id++;
     }
     public void add(HumanBeing hum){
          hum.setId(id+1);
          dataSet.add(hum);
          id++;
     }
     public LinkedList<HumanBeing> getdataSet() {
          return dataSet;
     }

     private void id_plusplus() {
          id++;
     }
     public long getSize(){
          return dataSet.size();
     }

     public String getFilename_from() {
          return filename_from;
     }

     public void clear(){
          dataSet.clear();
          id = 0;
     }


     public boolean removeByIdNonInclusive(long id, long count){

          ListIterator<HumanBeing> it = getdataSet().listIterator(0);
          while(it.hasNext()){
               if(it.next().getId() > id)
                    break;
          }
          if(it.previous()!= null){
               it.remove();
               int counter = 1;
               while(counter != count && it.hasNext()) {
                    it.next();
                    it.remove();
                    counter ++;
               }
               return true;
          }
          return false;
     }
     public boolean removeByIdInclusive(long id, long count){

          ListIterator<HumanBeing> it = getdataSet().listIterator(0);
          while(it.hasNext()){
               if(it.next().getId() >= id)
                    break;
          }
          if(it.previous()!= null){
               int counter = 0;
               while(counter != count) {
                    it.remove();
                    if(!it.hasNext())
                         break;
                    it.next();
                    counter++;
               }
               return true;
          }
          return false;
     }

     public boolean update(long id){
          if(id < 0 ){
               System.out.println("Id can't be less than 0");
               return false;
          }
          else {
               for (HumanBeing i : dataSet) {
                    if (id == i.getId()) {
                         i.setName(InputConsole.inputName());
                         i.setCoordinates(InputConsole.inputCoordinates());
                         i.setRealHero(InputConsole.inputRealHero());
                         i.setHasToothpick(InputConsole.inputHasToothPick());
                         i.setImpactSpeed(InputConsole.inputImpactSpeed());
                         i.setSoundtrackName(InputConsole.inputSoundtrackName());
                         i.setMinutesOfWaiting(InputConsole.inputMinutesOfWaiting());
                         i.setMood(InputConsole.inputMood());
                         i.setCar(InputConsole.inputCar());
                         return true;
                    }
               }
               return false;
          }
     }
     public boolean update(long id, LinkedList<String> commands){
          if(id < 0 ){
               System.out.println("Id can't be less than 0");
               return false;
          }
          else {
               for (HumanBeing i : dataSet) {
                    if (id == i.getId()) {
                         i.setName(InputConsole.inputName());
                         i.setCoordinates(InputConsole.inputCoordinates());
                         i.setRealHero(InputConsole.inputRealHero());
                         i.setHasToothpick(InputConsole.inputHasToothPick());
                         i.setImpactSpeed(InputConsole.inputImpactSpeed());
                         i.setSoundtrackName(InputConsole.inputSoundtrackName());
                         i.setMinutesOfWaiting(InputConsole.inputMinutesOfWaiting());
                         i.setMood(InputConsole.inputMood());
                         i.setCar(InputConsole.inputCar());
                         return true;
                    }
               }
               return false;
          }
     }

     public HumanBeing get(Long id){
          if(id < 0 ){
               System.out.println("Id can't be less than 0");
               return null;
          }
          for(HumanBeing i : dataSet){
               if(id.equals(i.getId()))
                    return i;
          }
          return null;
     }

     private int count_if(For_counter<HumanBeing> for_counter){
          int count = 0;
          for(HumanBeing i : dataSet){
               if(for_counter.is(i)){
                    count += 1;
               }
          }
          return count;
     }
     public void info(){
          //тип, дата инициализации, количество элементов и т.д.
          System.out.println("Collection: Linkedlist<HumanBeing>" +
                  "\ncount of persons: " + getSize() +
                  "\ndata of initialization: " + time +
                  "\ncount of persons with Car: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.getCar() != null;
                       }
                  }) +
                  "\ncount of persons with tooth pick: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.isHasToothpick();
                       }
                  }) +
                  "\ncount of persons who is real hero: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.getRealHero();
                       }
                  }) +
                  "\ncount of persons with mood:" +
                  "\n   sadness :: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.getMood() == Mood.SADNESS;
                       }
                  }) +
                  "\n   apathy  :: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.getMood() == Mood.APATHY;
                       }
                  }) +
                  "\n   frenzy  :: " + count_if(new For_counter<HumanBeing>() {
                       @Override
                       public boolean is(HumanBeing for_comp) {
                            return for_comp.getMood() == Mood.FRENZY;
                       }
                  })
          );
     }
}
