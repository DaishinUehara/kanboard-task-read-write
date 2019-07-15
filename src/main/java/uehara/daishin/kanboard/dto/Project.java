package uehara.daishin.kanboard.dto;

public class Project {
   public String id;
   public String name;
   public String isActive;
   public String token;
   public String lastModified;
   public String isPublic;
   public String isPrivate;
   public String defaultSwimlane;
   public String showDefaultSwimlane;
   public String description;
   public String identifier;
   public Url url;

   public class Url{
	   public String board;
	   public String calendar;
	   public String list;

   }
}
