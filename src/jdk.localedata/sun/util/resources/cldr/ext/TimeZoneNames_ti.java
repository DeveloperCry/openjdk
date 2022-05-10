/*
 * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * COPYRIGHT AND PERMISSION NOTICE
 *
 * Copyright (c) 1991-2020 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in https://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that either
 * (a) this copyright and permission notice appear with all copies
 * of the Data Files or Software, or
 * (b) this copyright and permission notice appear in associated
 * Documentation.
 *
 * THE DATA FILES AND SOFTWARE ARE PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT OF THIRD PARTY RIGHTS.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS INCLUDED IN THIS
 * NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR CONSEQUENTIAL
 * DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE DATA FILES OR SOFTWARE.
 *
 * Except as contained in this notice, the name of a copyright holder
 * shall not be used in advertising or otherwise to promote the sale,
 * use or other dealings in these Data Files or Software without prior
 * written authorization of the copyright holder.
 */

package sun.util.resources.cldr.ext;

import sun.util.resources.TimeZoneNamesBundle;

public class TimeZoneNames_ti extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] ETC_UTC = new String[] {
               "Coordinated Universal Time",
               "UTC",
               "",
               "",
               "",
               "",
            };
        final String[] Malaysia = new String[] {
               "Malaysia Time",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Singapore = new String[] {
               "Singapore Standard Time",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Indonesia_Central = new String[] {
               "Central Indonesia Time",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Indonesia_Eastern = new String[] {
               "Eastern Indonesia Time",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Indonesia_Western = new String[] {
               "Western Indonesia Time",
               "",
               "",
               "",
               "",
               "",
            };
        final Object[][] data = new Object[][] {
            { "UTC", ETC_UTC },
            { "Etc/UTC", ETC_UTC },
            { "Asia/Jakarta", Indonesia_Western },
            { "Asia/Kuching", Malaysia },
            { "Asia/Jayapura", Indonesia_Eastern },
            { "Asia/Makassar", Indonesia_Central },
            { "Europe/Dublin",
                new String[] {
                    "",
                    "",
                    "Irish Standard Time",
                    "",
                    "",
                    "",
                }
            },
            { "Europe/London",
                new String[] {
                    "",
                    "",
                    "British Summer Time",
                    "",
                    "",
                    "",
                }
            },
            { "Asia/Pontianak", Indonesia_Western },
            { "Asia/Singapore", Singapore },
            { "Europe/Belfast",
                new String[] {
                    "",
                    "",
                    "British Summer Time",
                    "",
                    "",
                    "",
                }
            },
            { "Asia/Kuala_Lumpur", Malaysia },
            { "timezone.excity.Asia/Aden", "Aden" },
            { "timezone.excity.Asia/Baku", "Baku" },
            { "timezone.excity.Asia/Dili", "Dili" },
            { "timezone.excity.Asia/Gaza", "Gaza" },
            { "timezone.excity.Asia/Hovd", "Hovd" },
            { "timezone.excity.Asia/Omsk", "Omsk" },
            { "timezone.excity.Asia/Oral", "Oral" },
            { "timezone.excity.Asia/Amman", "Amman" },
            { "timezone.excity.Asia/Aqtau", "Aqtau" },
            { "timezone.excity.Asia/Chita", "Chita" },
            { "timezone.excity.Asia/Dhaka", "Dhaka" },
            { "timezone.excity.Asia/Dubai", "Dubai" },
            { "timezone.excity.Asia/Kabul", "Kabul" },
            { "timezone.excity.Asia/Macau", "Macau" },
            { "timezone.excity.Asia/Qatar", "Qatar" },
            { "timezone.excity.Asia/Seoul", "Seoul" },
            { "timezone.excity.Asia/Tokyo", "Tokyo" },
            { "timezone.excity.Asia/Tomsk", "Tomsk" },
            { "timezone.excity.Africa/Juba", "Juba" },
            { "timezone.excity.Africa/Lome", "Lome" },
            { "timezone.excity.Asia/Almaty", "Almaty" },
            { "timezone.excity.Asia/Anadyr", "Anadyr" },
            { "timezone.excity.Asia/Aqtobe", "Aqtobe" },
            { "timezone.excity.Asia/Atyrau", "Atyrau" },
            { "timezone.excity.Asia/Beirut", "Beirut" },
            { "timezone.excity.Asia/Brunei", "Brunei" },
            { "timezone.excity.Asia/Hebron", "Hebron" },
            { "timezone.excity.Asia/Kuwait", "Kuwait" },
            { "timezone.excity.Asia/Manila", "Manila" },
            { "timezone.excity.Asia/Muscat", "Muscat" },
            { "timezone.excity.Asia/Riyadh", "Riyadh" },
            { "timezone.excity.Asia/Taipei", "Taipei" },
            { "timezone.excity.Asia/Tehran", "Tehran" },
            { "timezone.excity.Asia/Urumqi", "Urumqi" },
            { "timezone.excity.Europe/Kiev", "Kiev" },
            { "timezone.excity.Europe/Oslo", "Oslo" },
            { "timezone.excity.Europe/Riga", "Riga" },
            { "timezone.excity.Europe/Rome", "Rome" },
            { "timezone.excity.Indian/Mahe", "Mahe" },
            { "timezone.excity.Africa/Accra", "Accra" },
            { "timezone.excity.Africa/Cairo", "Cairo" },
            { "timezone.excity.Africa/Ceuta", "Ceuta" },
            { "timezone.excity.Africa/Dakar", "Dakar" },
            { "timezone.excity.Africa/Lagos", "Lagos" },
            { "timezone.excity.Africa/Tunis", "Tunis" },
            { "timezone.excity.America/Adak", "Adak" },
            { "timezone.excity.America/Lima", "Lima" },
            { "timezone.excity.America/Nome", "Nome" },
            { "timezone.excity.Asia/Baghdad", "Baghdad" },
            { "timezone.excity.Asia/Bahrain", "Bahrain" },
            { "timezone.excity.Asia/Bangkok", "Bangkok" },
            { "timezone.excity.Asia/Barnaul", "Barnaul" },
            { "timezone.excity.Asia/Bishkek", "Bishkek" },
            { "timezone.excity.Asia/Colombo", "Colombo" },
            { "timezone.excity.Asia/Irkutsk", "Irkutsk" },
            { "timezone.excity.Asia/Jakarta", "Jakarta" },
            { "timezone.excity.Asia/Karachi", "Karachi" },
            { "timezone.excity.Asia/Kuching", "Kuching" },
            { "timezone.excity.Asia/Magadan", "Magadan" },
            { "timezone.excity.Asia/Nicosia", "Nicosia" },
            { "timezone.excity.Asia/Rangoon", "Rangoon" },
            { "timezone.excity.Asia/Tbilisi", "Tbilisi" },
            { "timezone.excity.Asia/Thimphu", "Thimphu" },
            { "timezone.excity.Asia/Yakutsk", "Yakutsk" },
            { "timezone.excity.Asia/Yerevan", "Yerevan" },
            { "timezone.excity.Europe/Kirov", "Kirov" },
            { "timezone.excity.Europe/Malta", "Malta" },
            { "timezone.excity.Europe/Minsk", "Minsk" },
            { "timezone.excity.Europe/Paris", "Paris" },
            { "timezone.excity.Europe/Sofia", "Sofia" },
            { "timezone.excity.Europe/Vaduz", "Vaduz" },
            { "timezone.excity.Indian/Cocos", "Cocos" },
            { "timezone.excity.Pacific/Apia", "Apia" },
            { "timezone.excity.Pacific/Fiji", "Fiji" },
            { "timezone.excity.Pacific/Guam", "Guam" },
            { "timezone.excity.Pacific/Niue", "Niue" },
            { "timezone.excity.Pacific/Wake", "Wake" },
            { "timezone.excity.Africa/Bamako", "Bamako" },
            { "timezone.excity.Africa/Bangui", "Bangui" },
            { "timezone.excity.Africa/Banjul", "Banjul" },
            { "timezone.excity.Africa/Bissau", "Bissau" },
            { "timezone.excity.Africa/Douala", "Douala" },
            { "timezone.excity.Africa/Harare", "Harare" },
            { "timezone.excity.Africa/Kigali", "Kigali" },
            { "timezone.excity.Africa/Luanda", "Luanda" },
            { "timezone.excity.Africa/Lusaka", "Lusaka" },
            { "timezone.excity.Africa/Malabo", "Malabo" },
            { "timezone.excity.Africa/Maputo", "Maputo" },
            { "timezone.excity.Africa/Maseru", "Maseru" },
            { "timezone.excity.Africa/Niamey", "Niamey" },
            { "timezone.excity.America/Aruba", "Aruba" },
            { "timezone.excity.America/Bahia", "Bahia" },
            { "timezone.excity.America/Belem", "Belem" },
            { "timezone.excity.America/Boise", "Boise" },
            { "timezone.excity.America/Jujuy", "Jujuy" },
            { "timezone.excity.America/Sitka", "Sitka" },
            { "timezone.excity.America/Thule", "Thule" },
            { "timezone.excity.Asia/Ashgabat", "Ashgabat" },
            { "timezone.excity.Asia/Damascus", "Damascus" },
            { "timezone.excity.Asia/Dushanbe", "Dushanbe" },
            { "timezone.excity.Asia/Jayapura", "Jayapura" },
            { "timezone.excity.Asia/Khandyga", "Khandyga" },
            { "timezone.excity.Asia/Makassar", "Makassar" },
            { "timezone.excity.Asia/Qostanay", "Kostanay" },
            { "timezone.excity.Asia/Sakhalin", "Sakhalin" },
            { "timezone.excity.Asia/Shanghai", "Shanghai" },
            { "timezone.excity.Asia/Tashkent", "Tashkent" },
            { "timezone.excity.Asia/Ust-Nera", "Ust-Nera" },
            { "timezone.excity.Europe/Athens", "Athens" },
            { "timezone.excity.Europe/Berlin", "Berlin" },
            { "timezone.excity.Europe/Dublin", "Dublin" },
            { "timezone.excity.Europe/Jersey", "Jersey" },
            { "timezone.excity.Europe/Lisbon", "Lisbon" },
            { "timezone.excity.Europe/London", "London" },
            { "timezone.excity.Europe/Madrid", "Madrid" },
            { "timezone.excity.Europe/Monaco", "Monaco" },
            { "timezone.excity.Europe/Moscow", "Moscow" },
            { "timezone.excity.Europe/Prague", "Prague" },
            { "timezone.excity.Europe/Samara", "Samara" },
            { "timezone.excity.Europe/Skopje", "Skopje" },
            { "timezone.excity.Europe/Tirane", "Tirane" },
            { "timezone.excity.Europe/Vienna", "Vienna" },
            { "timezone.excity.Europe/Warsaw", "Warsaw" },
            { "timezone.excity.Europe/Zagreb", "Zagreb" },
            { "timezone.excity.Europe/Zurich", "Zurich" },
            { "timezone.excity.Indian/Chagos", "Chagos" },
            { "timezone.excity.Indian/Comoro", "Comoro" },
            { "timezone.excity.Pacific/Efate", "Efate" },
            { "timezone.excity.Pacific/Nauru", "Nauru" },
            { "timezone.excity.Pacific/Palau", "Palau" },
            { "timezone.excity.Africa/Abidjan", "Abidjan" },
            { "timezone.excity.Africa/Algiers", "Algiers" },
            { "timezone.excity.Africa/Conakry", "Conakry" },
            { "timezone.excity.Africa/Kampala", "Kampala" },
            { "timezone.excity.Africa/Mbabane", "Mbabane" },
            { "timezone.excity.Africa/Nairobi", "Nairobi" },
            { "timezone.excity.Africa/Tripoli", "Tripoli" },
            { "timezone.excity.America/Belize", "Belize" },
            { "timezone.excity.America/Bogota", "Bogota" },
            { "timezone.excity.America/Cancun", "Cancun" },
            { "timezone.excity.America/Cayman", "Cayman" },
            { "timezone.excity.America/Cuiaba", "Cuiaba" },
            { "timezone.excity.America/Dawson", "Dawson" },
            { "timezone.excity.America/Denver", "Denver" },
            { "timezone.excity.America/Guyana", "Guyana" },
            { "timezone.excity.America/Havana", "Havana" },
            { "timezone.excity.America/Inuvik", "Inuvik" },
            { "timezone.excity.America/Juneau", "Juneau" },
            { "timezone.excity.America/La_Paz", "La Paz" },
            { "timezone.excity.America/Maceio", "Maceio" },
            { "timezone.excity.America/Manaus", "Manaus" },
            { "timezone.excity.America/Merida", "Merida" },
            { "timezone.excity.America/Nassau", "Nassau" },
            { "timezone.excity.America/Panama", "Panama" },
            { "timezone.excity.America/Recife", "Recife" },
            { "timezone.excity.America/Regina", "Regina" },
            { "timezone.excity.Asia/Famagusta", "Famagusta" },
            { "timezone.excity.Asia/Hong_Kong", "Hong Kong" },
            { "timezone.excity.Asia/Jerusalem", "Jerusalem" },
            { "timezone.excity.Asia/Kamchatka", "Kamchatka" },
            { "timezone.excity.Asia/Pontianak", "Pontianak" },
            { "timezone.excity.Asia/Pyongyang", "Pyongyang" },
            { "timezone.excity.Asia/Qyzylorda", "Qyzylorda" },
            { "timezone.excity.Asia/Samarkand", "Samarkand" },
            { "timezone.excity.Asia/Singapore", "Singapore" },
            { "timezone.excity.Asia/Vientiane", "Vientiane" },
            { "timezone.excity.Europe/Andorra", "Andorra" },
            { "timezone.excity.Europe/Saratov", "Saratov" },
            { "timezone.excity.Europe/Tallinn", "Tallinn" },
            { "timezone.excity.Europe/Vatican", "Vatican" },
            { "timezone.excity.Europe/Vilnius", "Vilnius" },
            { "timezone.excity.Indian/Mayotte", "Mayotte" },
            { "timezone.excity.Indian/Reunion", "Reunion" },
            { "timezone.excity.Pacific/Easter", "Easter" },
            { "timezone.excity.Pacific/Kosrae", "Kosrae" },
            { "timezone.excity.Pacific/Majuro", "Majuro" },
            { "timezone.excity.Pacific/Midway", "Midway" },
            { "timezone.excity.Pacific/Noumea", "Noumea" },
            { "timezone.excity.Pacific/Saipan", "Saipan" },
            { "timezone.excity.Pacific/Tahiti", "Tahiti" },
            { "timezone.excity.Pacific/Tarawa", "Tarawa" },
            { "timezone.excity.Pacific/Wallis", "Wallis" },
            { "timezone.excity.Africa/Blantyre", "Blantyre" },
            { "timezone.excity.Africa/Djibouti", "Djibouti" },
            { "timezone.excity.Africa/El_Aaiun", "El Aaiun" },
            { "timezone.excity.Africa/Freetown", "Freetown" },
            { "timezone.excity.Africa/Gaborone", "Gaborone" },
            { "timezone.excity.Africa/Khartoum", "Khartoum" },
            { "timezone.excity.Africa/Kinshasa", "Kinshasa" },
            { "timezone.excity.Africa/Monrovia", "Monrovia" },
            { "timezone.excity.Africa/Ndjamena", "Ndjamena" },
            { "timezone.excity.Africa/Sao_Tome", "Sao Tome" },
            { "timezone.excity.Africa/Windhoek", "Windhoek" },
            { "timezone.excity.America/Antigua", "Antigua" },
            { "timezone.excity.America/Caracas", "Caracas" },
            { "timezone.excity.America/Cayenne", "Cayenne" },
            { "timezone.excity.America/Chicago", "Chicago" },
            { "timezone.excity.America/Cordoba", "Cordoba" },
            { "timezone.excity.America/Creston", "Creston" },
            { "timezone.excity.America/Curacao", "Curacao" },
            { "timezone.excity.America/Detroit", "Detroit" },
            { "timezone.excity.America/Grenada", "Grenada" },
            { "timezone.excity.America/Halifax", "Halifax" },
            { "timezone.excity.America/Iqaluit", "Iqaluit" },
            { "timezone.excity.America/Jamaica", "Jamaica" },
            { "timezone.excity.America/Managua", "Managua" },
            { "timezone.excity.America/Marigot", "Marigot" },
            { "timezone.excity.America/Mendoza", "Mendoza" },
            { "timezone.excity.America/Moncton", "Moncton" },
            { "timezone.excity.America/Nipigon", "Nipigon" },
            { "timezone.excity.America/Noronha", "Noronha" },
            { "timezone.excity.America/Ojinaga", "Ojinaga" },
            { "timezone.excity.America/Phoenix", "Phoenix" },
            { "timezone.excity.America/Tijuana", "Tijuana" },
            { "timezone.excity.America/Toronto", "Toronto" },
            { "timezone.excity.America/Tortola", "Tortola" },
            { "timezone.excity.America/Yakutat", "Yakutat" },
            { "timezone.excity.Asia/Choibalsan", "Choibalsan" },
            { "timezone.excity.Asia/Phnom_Penh", "Phnom Penh" },
            { "timezone.excity.Atlantic/Azores", "Azores" },
            { "timezone.excity.Atlantic/Canary", "Canary" },
            { "timezone.excity.Australia/Eucla", "Eucla" },
            { "timezone.excity.Australia/Perth", "Perth" },
            { "timezone.excity.Europe/Belgrade", "Belgrade" },
            { "timezone.excity.Europe/Brussels", "Brussels" },
            { "timezone.excity.Europe/Budapest", "Budapest" },
            { "timezone.excity.Europe/Busingen", "Busingen" },
            { "timezone.excity.Europe/Chisinau", "Chisinau" },
            { "timezone.excity.Europe/Guernsey", "Guernsey" },
            { "timezone.excity.Europe/Helsinki", "Helsinki" },
            { "timezone.excity.Europe/Istanbul", "Istanbul" },
            { "timezone.excity.Europe/Sarajevo", "Sarajevo" },
            { "timezone.excity.Europe/Uzhgorod", "Uzhgorod" },
            { "timezone.excity.Indian/Maldives", "Maldives" },
            { "timezone.excity.Pacific/Chatham", "Chatham" },
            { "timezone.excity.Pacific/Fakaofo", "Fakaofo" },
            { "timezone.excity.Pacific/Gambier", "Gambier" },
            { "timezone.excity.Pacific/Norfolk", "Norfolk" },
            { "timezone.excity.Africa/Bujumbura", "Bujumbura" },
            { "timezone.excity.Africa/Mogadishu", "Mogadishu" },
            { "timezone.excity.America/Anguilla", "Anguilla" },
            { "timezone.excity.America/Asuncion", "Asuncion" },
            { "timezone.excity.America/Barbados", "Barbados" },
            { "timezone.excity.America/Dominica", "Dominica" },
            { "timezone.excity.America/Edmonton", "Edmonton" },
            { "timezone.excity.America/Eirunepe", "Eirunepe" },
            { "timezone.excity.America/Mazatlan", "Mazatlan" },
            { "timezone.excity.America/Miquelon", "Miquelon" },
            { "timezone.excity.America/New_York", "New York" },
            { "timezone.excity.America/Resolute", "Resolute" },
            { "timezone.excity.America/Santarem", "Santarem" },
            { "timezone.excity.America/Santiago", "Santiago" },
            { "timezone.excity.America/Winnipeg", "Winnipeg" },
            { "timezone.excity.Antarctica/Casey", "Casey" },
            { "timezone.excity.Antarctica/Davis", "Davis" },
            { "timezone.excity.Antarctica/Syowa", "Syowa" },
            { "timezone.excity.Antarctica/Troll", "Troll" },
            { "timezone.excity.Asia/Krasnoyarsk", "Krasnoyarsk" },
            { "timezone.excity.Asia/Novosibirsk", "Novosibirsk" },
            { "timezone.excity.Asia/Ulaanbaatar", "Ulaanbaatar" },
            { "timezone.excity.Asia/Vladivostok", "Vladivostok" },
            { "timezone.excity.Atlantic/Bermuda", "Bermuda" },
            { "timezone.excity.Atlantic/Madeira", "Madeira" },
            { "timezone.excity.Atlantic/Stanley", "Stanley" },
            { "timezone.excity.Australia/Currie", "Currie" },
            { "timezone.excity.Australia/Darwin", "Darwin" },
            { "timezone.excity.Australia/Hobart", "Hobart" },
            { "timezone.excity.Australia/Sydney", "Sydney" },
            { "timezone.excity.Europe/Amsterdam", "Amsterdam" },
            { "timezone.excity.Europe/Astrakhan", "Astrakhan" },
            { "timezone.excity.Europe/Bucharest", "Bucharest" },
            { "timezone.excity.Europe/Gibraltar", "Gibraltar" },
            { "timezone.excity.Europe/Ljubljana", "Ljubljana" },
            { "timezone.excity.Europe/Mariehamn", "Mariehamn" },
            { "timezone.excity.Europe/Podgorica", "Podgorica" },
            { "timezone.excity.Europe/Stockholm", "Stockholm" },
            { "timezone.excity.Europe/Ulyanovsk", "Ulyanovsk" },
            { "timezone.excity.Europe/Volgograd", "Volgograd" },
            { "timezone.excity.Indian/Christmas", "Christmas" },
            { "timezone.excity.Indian/Kerguelen", "Kerguelen" },
            { "timezone.excity.Indian/Mauritius", "Mauritius" },
            { "timezone.excity.Pacific/Auckland", "Auckland" },
            { "timezone.excity.Pacific/Funafuti", "Funafuti" },
            { "timezone.excity.Pacific/Honolulu", "Honolulu" },
            { "timezone.excity.Pacific/Johnston", "Johnston" },
            { "timezone.excity.Pacific/Pitcairn", "Pitcairn" },
            { "timezone.excity.Africa/Casablanca", "Casablanca" },
            { "timezone.excity.Africa/Libreville", "Libreville" },
            { "timezone.excity.Africa/Lubumbashi", "Lubumbashi" },
            { "timezone.excity.Africa/Nouakchott", "Nouakchott" },
            { "timezone.excity.Africa/Porto-Novo", "Porto-Novo" },
            { "timezone.excity.America/Anchorage", "Anchorage" },
            { "timezone.excity.America/Araguaina", "Araguaina" },
            { "timezone.excity.America/Boa_Vista", "Boa Vista" },
            { "timezone.excity.America/Catamarca", "Catamarca" },
            { "timezone.excity.America/Chihuahua", "Chihuahua" },
            { "timezone.excity.America/Fortaleza", "Fortaleza" },
            { "timezone.excity.America/Glace_Bay", "Glace Bay" },
            { "timezone.excity.America/Goose_Bay", "Goose Bay" },
            { "timezone.excity.America/Guatemala", "Guatemala" },
            { "timezone.excity.America/Guayaquil", "Guayaquil" },
            { "timezone.excity.America/Matamoros", "Matamoros" },
            { "timezone.excity.America/Menominee", "Menominee" },
            { "timezone.excity.America/Monterrey", "Monterrey" },
            { "timezone.excity.America/Sao_Paulo", "Sao Paulo" },
            { "timezone.excity.America/Vancouver", "Vancouver" },
            { "timezone.excity.Antarctica/Mawson", "Mawson" },
            { "timezone.excity.Antarctica/Palmer", "Palmer" },
            { "timezone.excity.Antarctica/Vostok", "Vostok" },
            { "timezone.excity.Asia/Kuala_Lumpur", "Kuala Lumpur" },
            { "timezone.excity.Asia/Novokuznetsk", "Novokuznetsk" },
            { "timezone.excity.Europe/Bratislava", "Bratislava" },
            { "timezone.excity.Europe/Copenhagen", "Copenhagen" },
            { "timezone.excity.Europe/Luxembourg", "Luxembourg" },
            { "timezone.excity.Europe/San_Marino", "San Marino" },
            { "timezone.excity.Europe/Simferopol", "Simferopol" },
            { "timezone.excity.Europe/Zaporozhye", "Zaporozhye" },
            { "timezone.excity.Pacific/Enderbury", "Enderbury" },
            { "timezone.excity.Pacific/Galapagos", "Galapagos" },
            { "timezone.excity.Pacific/Kwajalein", "Kwajalein" },
            { "timezone.excity.Pacific/Marquesas", "Marquesas" },
            { "timezone.excity.Pacific/Pago_Pago", "Pago Pago" },
            { "timezone.excity.Pacific/Rarotonga", "Rarotonga" },
            { "timezone.excity.Pacific/Tongatapu", "Tongatapu" },
            { "timezone.excity.Africa/Addis_Ababa", "Addis Ababa" },
            { "timezone.excity.Africa/Brazzaville", "Brazzaville" },
            { "timezone.excity.Africa/Ouagadougou", "Ouagadougou" },
            { "timezone.excity.America/Costa_Rica", "Costa Rica" },
            { "timezone.excity.America/Grand_Turk", "Grand Turk" },
            { "timezone.excity.America/Guadeloupe", "Guadeloupe" },
            { "timezone.excity.America/Hermosillo", "Hermosillo" },
            { "timezone.excity.America/Kralendijk", "Kralendijk" },
            { "timezone.excity.America/Louisville", "Louisville" },
            { "timezone.excity.America/Martinique", "Martinique" },
            { "timezone.excity.America/Metlakatla", "Metlakatla" },
            { "timezone.excity.America/Montevideo", "Montevideo" },
            { "timezone.excity.America/Montserrat", "Montserrat" },
            { "timezone.excity.America/Paramaribo", "Paramaribo" },
            { "timezone.excity.America/Rio_Branco", "Rio Branco" },
            { "timezone.excity.America/Whitehorse", "Whitehorse" },
            { "timezone.excity.Antarctica/McMurdo", "McMurdo" },
            { "timezone.excity.Antarctica/Rothera", "Rothera" },
            { "timezone.excity.Asia/Srednekolymsk", "Srednekolymsk" },
            { "timezone.excity.Asia/Yekaterinburg", "Yekaterinburg" },
            { "timezone.excity.Atlantic/Reykjavik", "Reykjavik" },
            { "timezone.excity.Australia/Adelaide", "Adelaide" },
            { "timezone.excity.Australia/Brisbane", "Brisbane" },
            { "timezone.excity.Australia/Lindeman", "Lindeman" },
            { "timezone.excity.Europe/Isle_of_Man", "Isle of Man" },
            { "timezone.excity.Europe/Kaliningrad", "Kaliningrad" },
            { "timezone.excity.Pacific/Kiritimati", "Kiritimati" },
            { "timezone.excity.Africa/Johannesburg", "Johannesburg" },
            { "timezone.excity.America/El_Salvador", "El Salvador" },
            { "timezone.excity.America/Fort_Nelson", "Fort Nelson" },
            { "timezone.excity.America/Los_Angeles", "Los Angeles" },
            { "timezone.excity.America/Mexico_City", "Mexico City" },
            { "timezone.excity.America/Pangnirtung", "Pangnirtung" },
            { "timezone.excity.America/Porto_Velho", "Porto Velho" },
            { "timezone.excity.America/Puerto_Rico", "Puerto Rico" },
            { "timezone.excity.America/Rainy_River", "Rainy River" },
            { "timezone.excity.America/Tegucigalpa", "Tegucigalpa" },
            { "timezone.excity.America/Thunder_Bay", "Thunder Bay" },
            { "timezone.excity.America/Yellowknife", "Yellowknife" },
            { "timezone.excity.Arctic/Longyearbyen", "Longyearbyen" },
            { "timezone.excity.Atlantic/Cape_Verde", "Cape Verde" },
            { "timezone.excity.Australia/Lord_Howe", "Lord Howe" },
            { "timezone.excity.Australia/Melbourne", "Melbourne" },
            { "timezone.excity.Indian/Antananarivo", "Antananarivo" },
            { "timezone.excity.Pacific/Guadalcanal", "Guadalcanal" },
            { "timezone.excity.Africa/Dar_es_Salaam", "Dar es Salaam" },
            { "timezone.excity.America/Blanc-Sablon", "Blanc-Sablon" },
            { "timezone.excity.America/Buenos_Aires", "Buenos Aires" },
            { "timezone.excity.America/Campo_Grande", "Campo Grande" },
            { "timezone.excity.America/Danmarkshavn", "Danmarkshavn" },
            { "timezone.excity.America/Dawson_Creek", "Dawson Creek" },
            { "timezone.excity.America/Indianapolis", "Indianapolis" },
            { "timezone.excity.America/Punta_Arenas", "Punta Arenas" },
            { "timezone.excity.America/Rankin_Inlet", "Rankin Inlet" },
            { "timezone.excity.Antarctica/Macquarie", "Macquarie" },
            { "timezone.excity.Pacific/Bougainville", "Bougainville" },
            { "timezone.excity.Pacific/Port_Moresby", "Port Moresby" },
            { "timezone.excity.America/Cambridge_Bay", "Cambridge Bay" },
            { "timezone.excity.America/Port_of_Spain", "Port of Spain" },
            { "timezone.excity.America/Santo_Domingo", "Santo Domingo" },
            { "timezone.excity.America/Swift_Current", "Swift Current" },
            { "timezone.excity.Australia/Broken_Hill", "Broken Hill" },
            { "timezone.excity.America/Bahia_Banderas", "Bahia Banderas" },
            { "timezone.excity.America/Port-au-Prince", "Port-au-Prince" },
            { "timezone.excity.Atlantic/South_Georgia", "South Georgia" },
            { "timezone.excity.America/Argentina/Salta", "Salta" },
            { "timezone.excity.America/Argentina/Tucuman", "Tucuman" },
            { "timezone.excity.America/Argentina/Ushuaia", "Ushuaia" },
            { "timezone.excity.America/Argentina/La_Rioja", "La Rioja" },
            { "timezone.excity.America/Argentina/San_Juan", "San Juan" },
            { "timezone.excity.America/Argentina/San_Luis", "San Luis" },
            { "timezone.excity.America/Argentina/Rio_Gallegos", "Rio Gallegos" },
        };
        return data;
    }
}
