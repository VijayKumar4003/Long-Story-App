package com.dinocodeacademy.longstoryapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dinocodeacademy.longstoryapp.R
import com.dinocodeacademy.longstoryapp.model.StoryClass

class ListViewAdapter(
            private val mcontext:Context,
            private val storyClassArrayList:ArrayList<StoryClass>) : BaseAdapter() {


    override fun getCount(): Int {

        return storyClassArrayList.size

    }

    override fun getItem(position: Int): Any {
        return storyClassArrayList[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView
        val viewHolder : ViewHolder

        if (convertView == null){

            val layoutInflater = LayoutInflater.from(mcontext)

            convertView = layoutInflater.inflate(R.layout.list_item,parent,false)
            viewHolder = ViewHolder()


            viewHolder.time = convertView!!.findViewById<View>(R.id.time) as TextView
            viewHolder.title = convertView!!.findViewById<View>(R.id.title) as TextView
            viewHolder.comment = convertView!!.findViewById<View>(R.id.comment) as TextView
            viewHolder.profile = convertView!!.findViewById<View>(R.id.banner1) as ImageView

            convertView.tag = viewHolder
        }else{

            viewHolder = convertView.tag as ViewHolder
        }

        val storyClass = getItem(position) as StoryClass

        viewHolder.title!!.text = storyClass.title
        viewHolder.time!!.text = storyClass.time
        viewHolder.comment!!.text = storyClass.comment
        viewHolder.profile!!.setImageResource(storyClass.profile)

        return convertView

    }

    private inner class ViewHolder{

        internal var profile:ImageView? = null
        internal var title: TextView? = null
        internal var time: TextView? = null
        internal var comment: TextView? = null

    }



}