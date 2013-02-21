using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Weather
{
    public partial class frmTemperature : Form
    {
        public frmTemperature()
        {
            InitializeComponent();
        }

        private void hsTemp_Scroll(object sender, ScrollEventArgs e)
        {
            double temp = 0;
            lblCel.Text = hsTemp.Value.ToString();
            temp = (hsTemp.Value * 1.8) + 32;
            lblFah.Text = temp.ToString("N");
        }

        private void trbMeasure_Scroll(object sender, EventArgs e)
        {
            double mea;

            lblInch.Text = trbMeasure.Value.ToString();
            mea = trbMeasure.Value * 2.54; 
            lblCM.Text   = mea.ToString("N");



        }
    }
}
