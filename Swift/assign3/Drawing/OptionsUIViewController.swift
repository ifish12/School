//
//  OptionsView.swift
//  Drawing
//
//  Created by Shapiro, Geoff on 2016-02-25.
//  Copyright © 2016 Chris Chadillon. All rights reserved.
//

import UIKit

class OptionsUIViewController: UIViewController {

    @IBAction func OptionsChanged(sender: AnyObject) {
        PreviewPane.setNeedsDisplay()
    }

    
    
    @IBOutlet weak var LineWidth: UISlider!
    @IBOutlet weak var LineColor: UISegmentedControl!
    @IBOutlet weak var FilledSwitch: UISwitch!
    @IBOutlet weak var FillColor: UISegmentedControl!
    
    
    @IBOutlet weak var PreviewPane: PreviewPaneUIView!
     var myParent:OptionsSavable!
    
    var displayshape : Int!
    var previewOptions : Options = Options()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        
        LineWidth.value = Float(previewOptions.LineWidth)
        LineColor.selectedSegmentIndex = getIndexfromRGB(previewOptions.LineColor)
        FilledSwitch.on = previewOptions.Filled
        FillColor.selectedSegmentIndex = getIndexfromRGB(previewOptions.FillColor)


        PreviewPane.myParent = self        // Do any additional setup after loading the view, typically from a nib.
    }
    @IBAction func SaveBtnClicked(sender: UIBarButtonItem) {
        let theChosenOptions = Options(LineWidth: Double(LineWidth.value), LineColor: getRGBfromString(LineColor.titleForSegmentAtIndex(LineColor.selectedSegmentIndex)!), Filled: Bool(FilledSwitch.on), FillColor: getRGBfromString(FillColor.titleForSegmentAtIndex(FillColor.selectedSegmentIndex)!))
        
        myParent.saveOptions(theChosenOptions)
        
        self.dismissViewControllerAnimated(true, completion: nil)
    }
    @IBAction func CancelBtnClicked(sender: UIBarButtonItem) {
        self.dismissViewControllerAnimated(true, completion: nil)
    }
    
    func getRGBfromString(colorString: String?) -> [CGFloat] {
        var components: [CGFloat] = [0.0, 0.0, 1.0, 1.0]
        switch colorString {
        case "Red"?:
            components = [1.0, 0.0, 0.0, 1.0]
        case "Green"?:
            components = [0.0, 1.0, 0.0, 1.0]
        case "Blue"?:
            components = [0.0, 0.0, 1.0, 1.0]
        case "Yellow"?:
            components = [1.0, 1.0, 0.0, 1.0]
        case "Pink"?:
            components = [1.0, 0.45, 0.60, 1.0]
        case "Black"?:
            components = [0.0, 0.0, 0.0, 1.0]
        default:
            components = [0.0, 0.0, 0.0, 1.0]
        }
        return components;
    }
    
    func getIndexfromRGB(RGB: [CGFloat]?) -> Int {
        
        
        if(RGB! == [1.0, 0.0, 0.0, 1.0]){
            return 0
        }
        if(RGB! == [0.0, 1.0, 0.0, 1.0]){
            return 1
        }
        if(RGB! == [0.0, 0.0, 1.0, 1.0]){
            return 3
        }
        if(RGB! == [1.0, 0.45, 0.60, 1.0]){
            return 4
        }
        if(RGB! == [0.0, 0.0, 0.0, 1.0]){
            return 5
        }
            
        /*case [0.0, 1.0, 0.0, 1.0]?:
            components = 1
        case [0.0, 0.0, 1.0, 1.0]?:
            components = 2
        case [1.0, 1.0, 0.0, 1.0]?:
            components = 3
        case [1.0, 0.45, 0.60, 1.0]?:
            components = 4
        case [0.0, 0.0, 0.0, 1.0]?:
            components = 5
        default:
            components = 5
        }*/
        return 0
    }

    
}
