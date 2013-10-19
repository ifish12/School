package
{
	import flash.events.MouseEvent;
	import flash.display.MovieClip;
	
	public class docclass extends MovieClip 
	{
		public function docclass()
		{
			trace("Docclass constructor created!!");
			
		    btnCustom.addEventListener(MouseEvent.CLICK, ClickHandler);
		
			
		}
		 function ClickHandler(e:MouseEvent):void
		{
				trace("Blue button has been actuated");
		}
	}
}