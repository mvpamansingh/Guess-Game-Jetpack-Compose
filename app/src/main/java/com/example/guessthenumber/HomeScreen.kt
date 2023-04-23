package com.example.guessthenumber

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Composable
fun HomeScreen()
{
    var num by rememberSaveable {
        mutableStateOf("")
    }

    var ans by rememberSaveable {
        mutableStateOf(Random.nextInt(1,25).toString())
    }

    var tex by rememberSaveable {
        mutableStateOf("Guess 1 to 25")
    }
    var count1 by rememberSaveable {
            mutableStateOf(0)
    }
    var dis by rememberSaveable {
            mutableStateOf("??")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 10.dp, bottom = 10.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, ) {

            Text(text = tex, fontSize = 50.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text =dis, fontSize = 32.sp,
                fontWeight = FontWeight.Bold)


            Spacer(modifier = Modifier.height(26.dp))                      //         ans       --- gentrated by pc
                                                                    //          num  ---- enter by user

            OutlinedTextField(
                value = num,
                onValueChange = { num= it },
                label = {
                    Text(text = "Enter number")
                }

            )



            Spacer(modifier = Modifier.height(85.dp))
            Button(onClick = {
                    var num1= num.toInt()
                    var ans1 =ans.toInt()

                if(num1>ans1)
                {
                    tex= "Too high !!"
                    count1++
                }
                else if(num1<ans1)
                {
                    tex="Too low !!"
                    count1++
                }
                else
                {
                    tex = "You Got it !!"
                    dis= "count : "+ count1+" " + ans.toString()
                }

            }) {
                Text(text = "Submit")
                
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(onClick = {
                num =""
                ans= Random.nextInt(1,25).toString()
                tex = "Guess 1 to 25"
                dis = "??"
                count1= 0

            }) {
                Text(text = "Pla again")
                
            }


        }
    }

}