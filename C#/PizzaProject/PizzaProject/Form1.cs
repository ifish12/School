using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace PizzaProject
{

    public partial class Form1 : Form
    {
        double pizzaTotals;
        double tax;
        double sodaTotals;
        double toppTotals;
        double delivTotals;
        double total;

        public Form1()
        {
            InitializeComponent();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            picSoda.Visible = chkSoda.Checked;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void chkPizza_CheckedChanged(object sender, EventArgs e)
        {
             picPizza.Visible = chkPizza.Checked;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void rdbSmallS_CheckedChanged(object sender, EventArgs e)
        {
            if(rdbSmallS.Checked)
                sodaTotals = 10 + sodaTotals;
            else
                sodaTotals  = sodaTotals - 10;
            lblSodaTot.Text = sodaTotals.ToString("C");
        }

        private void rdbLargeS_CheckedChanged(object sender, EventArgs e)
        {
            if (rdbLargeS.Checked)
                sodaTotals = 30 + sodaTotals;
            else
                sodaTotals  = sodaTotals - 30;
            lblSodaTot.Text = sodaTotals.ToString("C");
        }

        private void chkMedP_CheckedChanged(object sender, EventArgs e)
        {
            if (chkMedP.Checked)
                pizzaTotals = 12 + pizzaTotals;
            else
                pizzaTotals  = pizzaTotals - 12;
            lblPizzaTot.Text = pizzaTotals.ToString("C");

        }

        private void chkLarP_CheckedChanged(object sender, EventArgs e)
        {
            if (chkLarP.Checked)
                pizzaTotals = 14 + pizzaTotals;
            else
                pizzaTotals  = pizzaTotals - 14;
            lblPizzaTot.Text = pizzaTotals.ToString("C");
        }

        private void chkMushrooms_CheckedChanged(object sender, EventArgs e)
        {
            if (chkMushrooms.Checked)
                toppTotals = 1.00 + toppTotals;
            else
                toppTotals  = toppTotals - 1.00;
            lblToppTot.Text = toppTotals.ToString("C");
        }

        private void chkPepperoni_CheckedChanged(object sender, EventArgs e)
        {
            if (chkPepperoni.Checked)
                toppTotals = 1.00 + toppTotals;
            else
                toppTotals = toppTotals - 1.00;
            lblToppTot.Text = toppTotals.ToString("C");
        }

        private void chkBacon_CheckedChanged(object sender, EventArgs e)
        {
            if (chkBacon.Checked)
                toppTotals = 1.50 + toppTotals;
            else
                toppTotals  = toppTotals - 1.50;
            lblToppTot.Text = toppTotals.ToString("C");
        }

        private void chkSmallP_CheckedChanged_1(object sender, EventArgs e)
        {
            if (chkSmallP.Checked)
                pizzaTotals = 10 + pizzaTotals;
            else
                pizzaTotals  = pizzaTotals - 10;
            lblPizzaTot.Text = pizzaTotals.ToString("C");
       
        }
       private void rdbOrange_CheckedChanged(object sender, EventArgs e)
        {
            if (rdbOrange.Checked)
                sodaTotals = 1.00 + sodaTotals;
            else
                sodaTotals  = sodaTotals - 1.00;
            lblSodaTot.Text = sodaTotals.ToString("C");
        }

        private void rdbGrape_CheckedChanged(object sender, EventArgs e)
        {
            if (rdbGrape.Checked)
                sodaTotals = 1.00 + sodaTotals;
            else
                sodaTotals = sodaTotals - 1.00;
            lblSodaTot.Text = sodaTotals.ToString("C");
        }

        private void rdbLemonLime_CheckedChanged(object sender, EventArgs e)
        {
            if (rdbLemonLime.Checked)
                sodaTotals = 1.50 + sodaTotals;
            else
                sodaTotals  = sodaTotals - 1.50;
            lblSodaTot.Text = sodaTotals.ToString("C");
        }

        private void rdbZone1_CheckedChanged(object sender, EventArgs e)
        {
            
                delivTotals = 30;
           
               
            lblDelivTot.Text = delivTotals.ToString("C");
        }

        private void rdbZone2_CheckedChanged(object sender, EventArgs e)
        {
          
                delivTotals = 40;
            
            lblDelivTot.Text = delivTotals.ToString("C");
        }

        private void rdbZoneX_CheckedChanged(object sender, EventArgs e)
        {
            
                delivTotals = 0;
            
                
            lblDelivTot.Text = delivTotals.ToString("C");
        }

        private void btnName_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Geoffrey Shapiro");
        }

        private void btnCalc_Click(object sender, EventArgs e)
        {
            tax = (pizzaTotals + delivTotals + toppTotals + sodaTotals) * 0.15;
            lblTaxTot.Text = tax.ToString("C");

            total = pizzaTotals + delivTotals + toppTotals + sodaTotals + tax;
            lblTotTot.Text = total.ToString("C");

        }

        private void Clear_Click(object sender, EventArgs e)
        {
            chkPizza.Checked = false;
            chkLarP.Checked = false;
            chkBacon.Checked = false;
            chkMedP.Checked = false;
            chkSmallP.Checked = false;
            chkMushrooms.Checked = false;
      8?     chkPepperoni.Checked = false;
            chkSoda.Checked = false;
            rdbSmallS.Checked = false;
            rdbLargeS.Checked = false;
            rdbNull1.Checked = true;
            rdbNull3.Checked = true;
            lblTaxTot.Text = " ";
            lblTotTot.Text = " ";
            lblDelivTot.Text = " ";
            lblPizzaTot.Text = " ";
            lblSodaTot.Text = " ";
            lblToppTot.Text = " ";

        }

        private void lblPizzaTot_Click(object sender, EventArgs e)
        {

        }

        private void lblSodaTot_Click(object sender, EventArgs e)
        {

        }/*

        private void lblToppTot_Click(object sender, EventArgs e)
        {

        }

        private void lblDelivTot_Click(object sender, EventArgs e)
        {

        }

        private void lblTaxTot_Click(object sender, EventArgs e)
        {

        }

        private void lblTotTot_Click(object sender, EventArgs e)
        {

        }

     
    }
}
