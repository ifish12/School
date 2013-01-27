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
    public partial class FrmArea : Form
    {
        public FrmArea()
        {
            InitializeComponent();
        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            txtLen.Clear();
            txtWid.Clear();
            lblAreaOut.Text = " ";
            // Set focus to first text box
            this.ActiveControl = this.txtLen;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnCal_Click(object sender, EventArgs e)
        {
            double length = 0;
            double width = 0;
            double area = 0;

         try
            {
                length = double.Parse(txtLen.Text);
            }

            catch (Exception ex)
            {
                MessageBox.Show("Your length is incorrect");
                MessageBox.Show(ex.Message);
                txtLen.Text = " ";
                this.ActiveControl = this.txtLen;
            }
         try
            {
                width = double.Parse(txtWid.Text);
            }

            catch (Exception ex)
            {
                MessageBox.Show("Your width is incorrect");
                MessageBox.Show(ex.Message);
                txtWid.Text = " ";
                this.ActiveControl = this.txtWid;
            }
         area = length * width;
         lblAreaOut.Text = area.ToString(("N"));
        }
    }
}
