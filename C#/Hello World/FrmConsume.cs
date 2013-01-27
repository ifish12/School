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
    public partial class FrmConsume : Form
    {
        public FrmConsume()
        {
            InitializeComponent();
        }

        private void FrmConsume_Load(object sender, EventArgs e)
        {

        }

        private void btnExt_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            txtBoxDist.Clear();
            txtBoxLit.Clear();
            txtBoxPL.Clear();
            libOut1.Text = " ";
            libOut2.Text = " ";
            // Set focus to first text box
            this.ActiveControl = this.txtBoxDist;
        }

        private void btnCalc_Click(object sender, EventArgs e)
        {

            double kpl;
            double cost;
            double distance;
            double liters;
            double price;

                kpl  = 0;
                cost = 0;
                distance = 0;
                liters   = 0;
                price    = 0;
            try
            {
                price = double.Parse(txtBoxPL.Text);
            }

            catch (Exception ex)
            {
                MessageBox.Show("You made a mistake on price(Are you retarded?)");
                MessageBox.Show(ex.Message);
                txtBoxPL.Text = " ";
                this.ActiveControl = this.txtBoxPL;
            }
            try
            {
                liters = double.Parse(txtBoxLit.Text);
            }

            catch (Exception ex)
            {
                MessageBox.Show("Fucked up the liters");
                MessageBox.Show(ex.Message);
                txtBoxLit.Text = " ";
                this.ActiveControl = this.txtBoxLit;
            }
           
            try

            {
                distance = double.Parse(txtBoxDist.Text);
            }

            catch (Exception ex)
            {
                MessageBox.Show("Fucked up the distance");
                MessageBox.Show(ex.Message);
                txtBoxDist.Text = " ";
                this.ActiveControl = this.txtBoxDist;
            }

           

                kpl  = distance / liters;
                cost = kpl * price;
                libOut1.Text = kpl.ToString(("N"));
                libOut2.Text = cost.ToString(("C"));
            

          
            
            
        }

        private void txtBoxDist_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxLit_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxPL_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
