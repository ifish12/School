using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace frmMenu
{
    public partial class frmNissain : Form
    {
        double basePrice = 0;


        double GST = 0.05;
        double PST = 0.0975;
        int options = 900;
        int air;
        bool work = false;
        double total = 0;
        double subTot = 0;
        double valueCar = 0;
        double gstTot = 0;
        double pstTot = 0;

        int year = 1;           // YEAR IF WHAT WAS PASSED FROM THE SCROLL BAR
        double rate = 0;        // RATE IS WHAT WAS PASSED FROM THE SCROLL BAR
        double amount = 1000;   // THIS IS THE VALUE PASSED FROM NUMERIC UP/DOWN

        double interest = 0;    // If monthly payment then interest = Rate/12/100 = .008333 FOR EACH MONTH
        // IF YEARLY PAYMENT DONT DIVIDE BY 12 BUT MUST HAVE DIV BY 100

        int numpay = 0;         // Number of payments  if monthly then (year*12)   IF YEARLY DONT MULTIPLY BY 12

        int start = 1;          // If 1  then payment are made beginning of month else 0 THEN END OF MONTH

        double payment = 0;     // THIS IS THE VALUE PASSED FROM THE FORMULA

        public frmNissain()
        {
            InitializeComponent();
            lblOptions.Text = options.ToString("C");
        }

        private void apr()
        {
            payment = (--amount * Math.Pow(1 + interest, numpay) + 0) /
                ((1 + interest * start) *
                ((Math.Pow((1 + interest), numpay) - 1) /
                interest));
            lblpayments.Text = payment.ToString("c");
        }

        private void Calculate()
        {
            subTot = basePrice + options + air + valueCar;
            lblSubTot.Text = subTot.ToString("C");

            gstTot = subTot * GST;
            lblGST.Text = gstTot.ToString("C");
            total = subTot + gstTot;

            pstTot = total * PST;
            lblPST.Text = pstTot.ToString("C");

            total = pstTot + gstTot + subTot;
            lblTot.Text = total.ToString("C");
            amount = total;
        }

        private void rdbCar1_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar1.Checked;

            if (rdbCar1.Checked)
                basePrice = basePrice + 19000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();

        }

        private void rdbCar2_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar2.Checked;

            if (rdbCar2.Checked)
                basePrice = basePrice + 38000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();
        }

        private void rdbCar3_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar3.Checked;

            if (rdbCar3.Checked)
                basePrice = basePrice + 22000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();
        }

        private void rdbCar4_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar4.Checked;

            if (rdbCar4.Checked)
                basePrice = basePrice + 41000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();
        }

        private void rdbCar5_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar5.Checked;

            if (rdbCar5.Checked)
                basePrice = basePrice + 30000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();
        }

        private void rdbCar6_CheckedChanged(object sender, EventArgs e)
        {
            grpOpt.Visible = rdbCar6.Checked;

            if (rdbCar6.Checked)
                basePrice = basePrice + 29000;
            else
                basePrice = 0;
            lblPrice.Text = basePrice.ToString("C");
            Calculate();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
                options = 1200 + options;
            else
                options = options - 1200;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox8_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox8.Checked)
                options = 100 + options;
            else
                options = options - 100;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox7_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox7.Checked)
            {
                options = 1100 + options;
                air = 100 + air;
            }
            else
            {
                options = options - 1100;
                air = air - 100;
            }
            lblOptions.Text = options.ToString("C");
            lblAir.Text = air.ToString("C");

            Calculate();
        }

        private void checkBox6_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox6.Checked)
                options = 200 + options;
            else
                options = options - 200;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox5_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox5.Checked)
                options = 50 + options;
            else
                options = options - 50;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox4_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox4.Checked)
                options = 1400 + options;
            else
                options = options - 1400;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox3_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox3.Checked)
                options = 300 + options;
            else
                options = options - 300;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
                options = 500 + options;
            else
                options = options - 500;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void checkBox9_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox9.Checked)
                options = 900 + options;
            lblOptions.Text = options.ToString("C");

            Calculate();
        }

        private void hsAPR_Scroll(object sender, ScrollEventArgs e)
        {
            rate = hsAPR.Value;
            interest = rate / 12 / 100;
            lblAPR.Text = rate.ToString("N");

            apr();
            Calculate();

        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            year = trbMonths.Value;
            
            numpay = year;
            lblMonths.Text = year.ToString();

            apr();
            Calculate();
        }

       

        private void btnCheck_Click(object sender, EventArgs e)
        {
            valueCar = double.Parse(txtTrade.Text);

            if (valueCar > basePrice)
            {
                MessageBox.Show("Your car cannot be worth more than the car you're trying to buy");
            }
            else
            {
                if (work == false)
                {
                    basePrice = basePrice - valueCar;
                    lblPrice.Text = basePrice.ToString("C");
                    lblTradeV.Text = valueCar.ToString("C");
                    work = true;
                }
                else
                    MessageBox.Show("You've already planned to trade in your car, no need to do it again.");
            }
            Calculate();
        }

        private void rdbNo_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void trbMonths_Scroll(object sender, EventArgs e)
        {
            year = trbMonths.Value;

            numpay = year * 12;
            lblMonths.Text = year.ToString();

            apr();
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            frmMenu newForm = new frmMenu();
            newForm.Show();
            this.Close();
        }

        private void hsAPR_Scroll_1(object sender, ScrollEventArgs e)
        {
            rate = hsAPR.Value;
            interest = rate / 12 / 100;
            lblAPR.Text = rate.ToString("N");

            apr();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void rdbYes_CheckedChanged_1(object sender, EventArgs e)
        {
            txtTrade.Visible = rdbYes.Checked;
            lblValue.Visible = rdbYes.Checked;
            btnCheck.Visible = rdbYes.Checked;
        }

        
        

    }
}
