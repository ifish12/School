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
    public partial class frmTest : Form
    {
        double number;
       

        public frmTest()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            number = double.Parse(textBox1.Text);

            if (number > 100)
            {
                MessageBox.Show("Please insert a number between 0 and 100");
                textBox1.Text = " ";
                textBox1.Focus();
            }
            if (number >= 90)
            {
                lblLetter.Text = "A";
            }
            else if (number > 80)
            {
                lblLetter.Text = "B";
            }
            else if (number > 70)
            {
                lblLetter.Text = "C";
            }
            else if (number > 60)
            {
                lblLetter.Text = "D";
            }
            else
                lblLetter.Text = "F";

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void txt1_TextChanged(object sender, EventArgs e)
        {
            double miles;

            if (double.TryParse(txt1.Text, out miles))
            {
                lblKilo.Text = Convert.ToString(miles * 1.61);
            }
            /*else if (textBox1.Text == "")
            {
                lblKilo.Text = " ";
            }*/

            else
            {
                
                txt1.Text = " ";
                txt1.Focus();
            }

        }

        private void lblKilo_Click(object sender, EventArgs e)
        {

        }

        private void btnGo2_Click(object sender, EventArgs e)
        {
            string hiRom = "";
            string lowRom = "";
            double remain = 0;
            int numb = 0;

            numb = int.Parse(txtRomNum.Text);

            if (numb >= 30)
            {
                hiRom = "XXX";
                remain = numb - 30;
            }
            else
                if (numb >= 20)
                {
                    hiRom = "XX";
                    remain = numb - 20;
                }
                else
                    if (numb >= 10)
                    {
                        hiRom = "X";
                        remain = numb - 10;
                    }
                    else
                        remain = numb;
            if (remain == 1)
            {
                lowRom = "I";
            }
            else
                if (remain == 2)
            {
                lowRom = "II";
            }
            else if (remain == 3)
            {
                lowRom = "III";
            }

                else if (remain == 4)
                {
                    lowRom = "IV";
                }
                else if (remain == 5)
                {
                    lowRom = "V";
                }
                else if (remain == 6)
                {
                    lowRom = "VI";
                }
                else if (remain == 7)
                {
                    lowRom = "VII";
                }
                else if (remain == 8)
                {
                    lowRom = "VIII";
                }
                else if (remain == 9)
                {
                    lowRom = "IX";
                }


            lblRomOut.Text = hiRom+lowRom;



        }

        private void txtRomNum_TextChanged(object sender, EventArgs e)
        {

        }

       
    }
}
