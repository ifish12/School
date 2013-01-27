using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace First_Project
{
    public partial class FrmDate1 : Form
    {
        public FrmDate1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
        // Program written by Geoffrey Shapiro 
        // on Jan 22nd, 2013
        private void lblOutput_Click(object sender, EventArgs e)
        {
            
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnShow_Click(object sender, EventArgs e)
        {
        // Declare my variables
            string output;
            output = txtDay.Text      + ", " +
                     txtDaymonth.Text + ", " +  
                     txtMonth.Text    + ", " + 
                     txtYear.Text;
            lblOutput.Text = output;


        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            txtDay.Clear();
            txtDaymonth.Clear();
            txtMonth.Clear();
            txtYear.Clear();
            lblOutput.Text = " ";
            // Set focus to first text box
            this.ActiveControl = this.txtDay;
            // Different way of setting focus
            txtDay.Focus();

                                 

        }

        private void txtYear_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
