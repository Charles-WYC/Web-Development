<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "user_detail".
 *
 * @property string $username
 * @property string $email
 * @property string $ID_number
 * @property string $photo
 *
 * @property User $username0
 */
class Userdetail extends \yii\db\ActiveRecord
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'user_detail';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['username'], 'required'],
            [['username', 'ID_number'], 'string', 'max' => 20],
            [['email'], 'string', 'max' => 50],
            [['photo'], 'string', 'max' => 1],
            [['username'], 'exist', 'skipOnError' => true, 'targetClass' => User::className(), 'targetAttribute' => ['username' => 'username']],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'username' => 'Username',
            'email' => 'Email',
            'ID_number' => 'Id Number',
            'photo' => 'Photo',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getUsername0()
    {
        return $this->hasOne(User::className(), ['username' => 'username']);
    }
}
