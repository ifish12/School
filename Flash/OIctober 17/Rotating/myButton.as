package
{
	import flash.display.MovieClip;
	
	public class myButton extends MovieClip
	{
		public function myButton(btnText:String)
		{
			trace("Button class constructor called");
			this.myWord.text = btnText;		//put text passed from button instantiation in document class into the button textbox
											//myWord is the name of the dynamic textbox on the button
		}
	}
}