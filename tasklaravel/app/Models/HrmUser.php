<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class HrmUser extends Model
{
    use HasFactory;
    protected $fillable = ["name","department", "file_path", "created_at", "updated_at"];
    protected $table="hrm_users";
}
