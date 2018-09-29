package com.qiushui.blurredviewdemo

import android.util.Log.println
import android.view.View
import android.widget.TextView
import java.util.*

/**
 * @author lifei
 */
class SecondActivity {
    /**
     * 对象
     */
    object Company {
        const val name: String = "Keep"//对象常量

    }

    /**
     *1，变量,m默认变量不为空
     */
    var text: String = "Hello"//定义变量,立即赋值
    val textFinal: String = "Hello"//定义final常量
    var b = 2//自动推断Int类型
    var c: Double = 2.5
    var d: String = ""
    var ob: Any? = null
    var textView: TextView? = null
    var list: List<String>? = null


    /**
     *
     * 2，函数
     * 快捷键 void  定义无返回值的函数，fun0定义无参数的函数，fun1定义包含一个参数的函数，fun2定义包含两个参数函数
     */
    fun sum(a: Int, b: Int): Int {//有返回值
        return a + b
    }

    fun sum2(a: String, b: String) = a + b//有返回值

    fun sum2(a: Int) = 5//有返回值自动推断

    fun sum3(): Unit {}//无返回值

    fun sum4() {}//无返回值，省略形式

    fun main(args: Array<String>) {
        System.out.print(sum(1, 2))
//        var cantNull = "can not be empty"
        var cantNull: String? = null
        System.out.print(cantNull.toString())//普通调用
        System.out.print(cantNull?.toString())//空检查，不为空才执行后面的

    }

    fun testIs() {

        //object
        var a: Any? = null
        a = 3L


        //if
        if (a is Long) {
            System.out.print("a is Long")
        } else if (a is Int) {
            System.out.print("a is Int")
        } else {
            System.out.print("a is other")
        }

        //switch  =
        when (a) {
            is Int -> System.out.println("a is Int")
            is Long -> System.out.println("a is Long")
            is Double -> System.out.println("a is Double")
            else -> System.out.println("a is other")
        }
        a = 2
        //switch ..范围
        when (a) {
            in 1..3 -> System.out.println("a in 1-3")
            in 2..4 -> System.out.println("a in 2-4")
            else -> System.out.println("a >4")
        }

        //强制转换 在后面
        textView = View(null) as TextView

        list = ArrayList<String>()


        //增强for遍历
        (list as ArrayList<String>).forEach { System.out.println(it) }
        //



    }


    /**
     * 定义类
     */
    class OriginActivity {}

    open class TestActivity {}
    /**
     * 继承:  实现，
     */
    class Test2Activity : TestActivity(), ICallBack {
        override fun success(): Boolean {
            System.out.print("success")
            return true
        }
    }

    /**
     * 定义接口
     */
    interface ICallBack {
        fun success(): Boolean
    }


}