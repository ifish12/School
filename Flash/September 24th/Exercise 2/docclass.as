package
{
	import flash.events.MouseEvent;
	import flash.display.MovieClip;
	
	public class docclass extends MovieClip 
	{
		public function docclass()
		{
			trace("Docclass constructor created!!");
			
		    var btnSymbol:btnClass = new btnClass; 
			
			btnSymbol.buttonMode = true;
			btnSymbol.x = 100;
			btnSymbol.y = 100;
			
			stage.addChild(btnSymbol);
			
			btnSymbol.addEventListener(MouseEvent.CLICK, ClickHandler);

			// attach to your stage
			// set your listner

		}
		 function ClickHandler(e:MouseEvent):void
		 {
				trace("Blue button has been actuated");
				/*btnSymbol.buttonMode = true;
				btnSymbol.x = 100;
				btnSymbol.y = 100;*/
		 }
		
		
		
		// here put your event handler.
		
	}
	
}