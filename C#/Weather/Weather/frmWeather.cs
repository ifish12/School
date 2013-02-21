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
    public partial class frmWeather : Form
    {
        private double celcius = 0;
        private double farenheit = 0;
        private double input = 0;

        public frmWeather()
        {
            InitializeComponent();
        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            txtNumval.Clear();
            lblOutput.Text = " ";
           
            this.ActiveControl = this.txtNumval;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void txtNumval_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnFar_Click(object sender, EventArgs e)
        {
            try
            {
                input = double.Parse(txtNumval.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show("You need to input a number");
                MessageBox.Show(ex.Message);
                txtNumval.Text = " ";
                this.ActiveControl = this.txtNumval;
            }
            farenheit = input * 1.8;
            farenheit = farenheit + 32;

            lblOutput.Text = farenheit.ToString(("N"));
        }

        private void btnCelcius_Click(object sender, EventArgs e)
        {
             try
            {
                input = double.Parse(txtNumval.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show("You need to input a number");
                MessageBox.Show(ex.Message);
                txtNumval.Text = " ";
                this.ActiveControl = this.txtNumval;
            }
             celcius = (input - 32) * 5 / 9; 

            lblOutput.Text = celcius.ToString(("N"));
        }

        
    }
}
