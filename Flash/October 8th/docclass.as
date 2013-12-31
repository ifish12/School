package
{
	import flash.events.*;
	import flash.display.MovieClip;
	import flash.display.SimpleButton;
	
	
	
	public class docclass extends MovieClip 
	{
		var CarSYM:Car = new Car;
		var w:int = new int;
		public function docclass()
		{
			
		    var btnD:btn = new btn("Down");
			var btnU:btn = new btn("Up");
			var btnW:btn = new btn("Left");
		    var btnE:btn = new btn("Right");
		
			trace("Docclass constructor created!!");
			
   			
			CarSYM.x = 345;
			CarSYM.y = 368;
			
		    btnE.x = 188;
			btnE.y = 644;
			
			btnU.x = 127;
			btnU.y = 581;
			
			btnW.x = 69;
			btnW.y = 644;
			
			btnD.x = 130;
			btnD.y = 705;
			
			stage.addChild(btnW);
			stage.addChild(btnE);
			stage.addChild(btnU);
			stage.addChild(btnD);
			stage.addChild(CarSYM);
			
			
			btnD.addEventListener(MouseEvent.CLICK, ClickHandlerDOWN);
			btnE.addEventListener(MouseEvent.CLICK, ClickHandlerRIGHT);
			btnW.addEventListener(MouseEvent.CLICK, ClickHandlerLEFT);
			btnU.addEventListener(MouseEvent.CLICK, ClickHandlerUP);
			//btnD.addEventListener(Event.ENTER_FRAME ,Go);
			
			

		}
	     function ClickHandlerUP(e:MouseEvent):void
		 {
				trace("Moving up");
				w = 1;
				CarSYM.Move(w);
				
		 }
		 
		  function ClickHandlerDOWN(e:MouseEvent):void
		 {
				trace("Moving down");
				w = 2;
				CarSYM.Move(w);
				
		 }
	
	 function ClickHandlerLEFT(e:MouseEvent):void
		 {
				trace("Moving left");
				w = 4;
				CarSYM.Move(w);
		 }
		 
		  function ClickHandlerRIGHT(e:MouseEvent):void
		 {
				trace("Moving right");
				w = 3;
				CarSYM.Move(w);
		 }
		 
		
		 
		/* function Go (e:Event):void
		 {
			 CarSYM.y++;
		 }*/
	
	}
}