using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project_3
{
    public partial class frmWhile : Form
    {
        double StartingBalance = 0;
        int NumbMonth = 0;
        const double PERCENT = .005;
        int count = 1;


        public frmWhile()
        {
            InitializeComponent();
        }

        private void frmWhile_Load(object sender, EventArgs e)
        {

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btncalc_Click(object sender, EventArgs e)
        {
            if (double.TryParse(txtBal.Text, out StartingBalance))
            {
                if (int.TryParse(txtNumMonth.Text, out NumbMonth))


                    while (count <= NumbMonth)
                    {
                        StartingBalance = StartingBalance + (StartingBalance * PERCENT);
                        lstOut.Items.Add("The amount for the month " + count.ToString() + " " + StartingBalance.ToString("C"));

                        count++;
                    }
                else
                    MessageBox.Show("Your month is incorrect");
            }

            else
                MessageBox.Show("Your Balance is incorrect");
            lblOut.Text = StartingBalance.ToString("C");
        }

        private void btnClr_Click(object sender, EventArgs e)
        {
            txtNumMonth.Text = "";
            txtBal.Text = "";
            lstOut.Items.Clear();
            lblOut.Text = "";
        }

        private void frmWhile_DoubleClick(object sender, EventArgs e)
        {
            ColorDialog diag = new ColorDialog();
            diag.ShowDialog();
            BackColor = diag.Color;
        }

    }
}
