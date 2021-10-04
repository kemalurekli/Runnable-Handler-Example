# Runnable-Handler-Example
##### Purpose of the project is  using periodically operations with runnables and handlers in back tread.

  The Application has 1 activity 1 fragment. <b>(NavhostFragment).</b> The application was created with <b>View Binding, Navigation.</b>

#### App Screenshots

<table>
  <tr>
    <td>First Screen Page</td>
     <td>Start button was pressed</td>
     <td>Data is checking every 5 seconds.</td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/66143323/135717816-e914ac85-ed80-4e24-8b2b-b0c9d92960fa.png" width=270 height=480></td>
    <td><img src="https://user-images.githubusercontent.com/66143323/135717818-22f0d794-f71f-444f-8616-93521e103062.png" width=270 height=480></td>
    <td><img src="https://user-images.githubusercontent.com/66143323/135717821-d4638fcf-3bbf-4d92-9dc3-799ace2233d7.png" width=270 height=480></td>
  </tr>
 </table>
        
#### I used 'if-else condition' for every 5 second operation in the project but I don't have to use any conditions as you can see in code block. Already, handler needs a time period. Runnable and Handler can manage operations in back tread without any time conditions.
`<handler.postDelayed(this,1000)>`
 
                override fun run()
                {
                    number = number + 1
                    binding.tvTime.text = "Time: $number"
                    binding.tvTime.visibility = View.VISIBLE
                    binding.tvUpdated.visibility = View.INVISIBLE
                    if(number%5==0){
                        binding.tvCheckingData.visibility = View.VISIBLE
                    }else{
                        binding.tvCheckingData.visibility = View.INVISIBLE
                        binding.tvUpdated.visibility = View.VISIBLE
                    }
                    //Number increase every second.
                    handler.postDelayed(this,1000)
                }
            }
            handler.post(runnable)
        }
 
