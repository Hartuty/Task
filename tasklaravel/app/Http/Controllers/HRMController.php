<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\HrmUser;
use Illuminate\Support\Facades\DB;


class HRMController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $data=DB::table('hrm_users')->get();
        return view('users.task',['data'=>$data]);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        echo 'here';
        // Validate the inputs
        $request->validate([
            'name' => 'required',
            'department'=>'required',
        ]);

        // ensure the request has a file before we attempt anything else.
        if ($request->hasFile('file')) {

            $request->validate([
                'image' => 'mimes:jpeg,bmp,png' // Only allow .jpg, .bmp and .png file types.
            ]);

            // Save the file locally in the storage/public/ folder under a new folder named /product
            $request->file->store('images', 'public');

            // Store the record, using the new file hashname which will be it's new filename identity.
            $user = new HrmUser([
                "name" => $request->get('name'),
                "department" => $request->get('department'),
                "file_path" => $request->file->hashName()
            ]);
            $user->save(); 
        }
        $data=DB::table('hrm_users')->get();
        return view('users.task',['data'=>$data]);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function delete($id)
    {
        DB::table('hrm_users')->where('id',$id)->delete();
        $data=DB::table('hrm_users')->get();
        return view('users.task',['data'=>$data]);
    }
    public function getallusers()
    {
        $users=DB::table('hrm_users')->get();
        return response()->json([
            "status"=>"success",
            "data"=>$users
        ]);
    }
}
